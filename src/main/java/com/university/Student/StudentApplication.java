package com.university.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2

@EnableEurekaClient
public class StudentApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	 @Bean
	    public Docket StudentApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	               .select()
//	               .paths(PathSelectors.ant("/api/*"))
	               .apis(RequestHandlerSelectors.basePackage("com.university.Student"))
	               //PathSelectors.any() for all
	               .build().apiInfo(apiDetails());
	    }
	 
	 private ApiInfo apiDetails() {
	        ApiInfo apiInfo = new ApiInfo(
	                "student API",
	                "This API will provide information about student details",
	                "1.0.0",
	                "Free to use",
	                "stud@org.com",
	                "API license: Apache 2.0",
	                "http://www.apache.org/licenses/LICENSE-2.0.html");
//	                Collections.emptyList());
	        return apiInfo;
	    }
}


