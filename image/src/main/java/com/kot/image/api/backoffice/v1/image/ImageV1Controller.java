package com.kot.image.api.backoffice.v1.image;

import java.io.IOException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kot.image.api.common.ApiInfo;
import com.kot.image.exception.MaxFileSizeException;
import com.kot.image.exception.WrongFileFormatException;

@RestController
@RequestMapping(ImageV1Controller.API_URL)
@Tag(name = "API for sending files to the Blob storage")
public class ImageV1Controller {

	public static final String API_URL = ApiInfo.API_PREFIX + ApiInfo.BACKOFFICE_VERSION_V1 + ApiInfo.IMAGE_ENDPOINT;

	@Autowired
	private ImageV1ApiService imageV1ApiService;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "406", description = "Not acceptable format of file"),
			@ApiResponse(responseCode = "413", description = "The file size is too large"),
			@ApiResponse(responseCode = "200", description = "Successful processed file")
	})
	@Operation(description = "Upload image file")
	public ImageV1Response upload(@RequestParam("file") MultipartFile file) throws WrongFileFormatException, MaxFileSizeException, IOException {
		return imageV1ApiService.uploadFile(file);
	}


	@GetMapping(value = "/{imageName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "image was not found"),
			@ApiResponse(responseCode = "200", description = "Successful found image")
	})
	@Operation(description = "Get image by name")
	public Resource get(@PathVariable String imageName) throws IOException {
		return imageV1ApiService.getImageFromStorage(imageName);
	}
}
