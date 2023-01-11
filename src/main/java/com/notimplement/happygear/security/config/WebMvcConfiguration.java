package com.notimplement.happygear.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("*")
			.allowedOrigins("http://localhost:3001")
			.allowedHeaders("*")
			.allowCredentials(true)
			.maxAge(-1);
	}
}
