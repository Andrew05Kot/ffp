package com.kot.image.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.kot.image.exception.MaxFileSizeException;
import com.kot.image.exception.WrongFileFormatException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageService {

	String uploadFile(MultipartFile file) throws IOException, WrongFileFormatException, MaxFileSizeException;

	ByteArrayResource getImageFromStorage(String fileName) throws FileNotFoundException;

}
