package com.kot.image.api.backoffice.v1.image;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.kot.image.exception.MaxFileSizeException;
import com.kot.image.exception.WrongFileFormatException;
import com.kot.image.service.ImageStorageService;

@Service
public class ImageV1ApiService {

	@Value("${com.kot.image.server.url}")
	private String serverUrl;

	@Autowired
	private ImageStorageService imageStorageService;

	public ImageV1Response uploadFile(MultipartFile file) throws WrongFileFormatException, MaxFileSizeException, IOException {
		String fileName = imageStorageService.uploadFile(file);
		String url = ImageV1Controller.API_URL + "/" + fileName;
		return new ImageV1Response(serverUrl + url);
	}

	public ByteArrayResource getImageFromStorage(String name) throws FileNotFoundException {
		return imageStorageService.getImageFromStorage(name);
	}
}
