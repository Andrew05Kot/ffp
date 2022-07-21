package com.kot.image.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import com.kot.image.exception.MaxFileSizeException;
import com.kot.image.exception.WrongFileFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LocalImageStorageService implements ImageStorageService {

	private final Logger LOGGER = LoggerFactory.getLogger(LocalImageStorageService.class );

	@Value("${com.kot.image.maxImageSize}")
	private Integer maxImageSize;

	@Value("#{'${com.kot.image.formats}'.split(',')}")
	private List<String> supportedFormats;

	@Value("${com.kot.image.folderName}")
	private String folderNameWithImages;

	@Override
	public String uploadFile(MultipartFile multipartFile) throws IOException, WrongFileFormatException, MaxFileSizeException {
		validateMultipartFile(multipartFile);
		String fileName = getRandomUUID() + multipartFile.getOriginalFilename();
		File directory = new File(getRootDirectory() + folderNameWithImages);
		Path path = Paths.get(directory.toPath() + File.separator + fileName);
		try {
			byte[] bytes = multipartFile.getBytes();
			Files.write(path, bytes);
			LOGGER.info("Successfully saved image {} to {}", fileName, path);
			return fileName;
		} catch (IOException e) {
			LOGGER.error("Can't save image ", e);
			throw new IOException("Failed to upload {}", e);
		}
	}

	@Override
	public ByteArrayResource getImageFromStorage(String fileName) throws FileNotFoundException {
		Path imagePath = Paths.get(getRootDirectory() + folderNameWithImages).resolve(fileName.trim());
		try {
			ByteArrayResource body = new ByteArrayResource(Files.readAllBytes(imagePath));
			if (!body.exists()) {
				throw new FileNotFoundException("Image was not found");
			}
			return body;
		} catch (IOException e) {
			LOGGER.error("Filed to find image {}", fileName);
			throw new FileNotFoundException("Can't get image");
		}
	}

	private void validateMultipartFile(MultipartFile multipartFile) throws WrongFileFormatException, MaxFileSizeException {
		if (!supportedFormats.contains(multipartFile.getContentType())) {
			throw new WrongFileFormatException(supportedFormats);
		}
		if (multipartFile.getSize() >= maxImageSize) {
			throw new MaxFileSizeException(maxImageSize);
		}
	}

	private UUID getRandomUUID() {
		return UUID.randomUUID();
	}

	private String getRootDirectory() {
		return System.getProperty("user.home", ".");
	}

}