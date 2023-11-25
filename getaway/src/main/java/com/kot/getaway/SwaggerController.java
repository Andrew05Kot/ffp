//package com.kot.getaway;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import org.springdoc.core.AbstractSwaggerUiConfigProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class SwaggerController {
//
//	private final DiscoveryClient discoveryClient;
//
//	@Autowired
//	public SwaggerController(final DiscoveryClient discoveryClient) {
//		this.discoveryClient = discoveryClient;
//	}
//
//	@GetMapping("/v3/api-docs/swagger-config")
//	public Map<String, Object> swaggerConfig(ServerHttpRequest serverHttpRequest) throws URISyntaxException {
//		URI uri = serverHttpRequest.getURI();
//		String url = new URI(uri.getScheme(), uri.getAuthority(), null, null, null).toString();
//		Map<String, Object> swaggerConfig = new LinkedHashMap<>();
//		List<AbstractSwaggerUiConfigProperties.SwaggerUrl> swaggerUrls = new LinkedList<>();
//		discoveryClient.getServices().forEach(serviceName ->
//				swaggerUrls.add(
//						new AbstractSwaggerUiConfigProperties.SwaggerUrl(serviceName, url + "/" + serviceName + "/v3/api-docs", serviceName)
//				));
//		swaggerConfig.put("urls", swaggerUrls);
//		return swaggerConfig;
//	}
//}
