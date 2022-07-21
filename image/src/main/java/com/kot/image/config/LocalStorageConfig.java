package com.kot.image.config;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalStorageConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(LocalStorageConfig.class);

	@Value("${com.kot.image.folderName}")
	private String folderNameWithImages;

	@Bean
	public void imagesFolderInitialization() {
		String rootDirectory = System.getProperty("user.home", ".");
		String folderWithImages = folderNameWithImages;
		File directory = new File(rootDirectory + folderWithImages);
		if (!directory.exists()) {
			directory.mkdir();
			LOGGER.info("created new directory {}", directory.getAbsolutePath());
		}
	}
}
