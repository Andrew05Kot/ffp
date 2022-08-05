package com.kot.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI getOpenApiV1() {
		return new OpenAPI()
				.components(new Components())
				.info(getApiInfo()
				);
	}

	@Bean
	public GroupedOpenApi getBackofficeApi() {
		String paths[] = {"/api/v1/**"};
		return GroupedOpenApi.builder().group("backoffice").pathsToMatch(paths)
				.build();
	}

	@Bean
	public GroupedOpenApi getMobileApi() {
		String paths[] = {"/api/mobile/v1/**"};
		return GroupedOpenApi.builder().group("mobile").pathsToMatch(paths)
				.build();
	}

	private Info getApiInfo() {
		return new Info()
				.title("FFP API")
				.contact(getDevelopmentContact())
				.version("V1.0");
	}

	private Contact getDevelopmentContact() {
		return new Contact().name("Kot studio team").email("kotygaandrey05@gmail.com");
	}

}