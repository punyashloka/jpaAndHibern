package com.example.jpa.demoSpringData.config;

// The static import is used for the regex(..) method.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(springfox.documentation.builders.RequestHandlerSelectors.basePackage("com.example.jpa.demoSpringData.controller"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());



		return docket;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("SpringBoot Swagger JPA", "SpringBoot Swagger JPA Rest API", "1.0", "Terms of service",
				new springfox.documentation.service.Contact("", "", ""), "Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
