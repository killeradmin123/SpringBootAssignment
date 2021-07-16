package com.syed.spring.assignment.swaggerConfig;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(scanBasePackages = {"com.syed.spring"})
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket EmployeeApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.syed.spring"))
				.paths(PathSelectors.regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}
	private ApiInfo metaInfo()
	{
		ApiInfo apiInfo=new ApiInfo("Spring Boot Swagger Assignment", 
				"Spring Boot Swagger Assignment For Interview", "1.0", 
				"Term of Service", new Contact("Syed Zulfaquar Nasar","https://github.com/killeradmin123","syedzulfaquar92@gmail.com"), 
				"Apache License Version 2.0", "https://www.apache.org/license.html");
		return apiInfo;
	}
	

} 
