package com.assignment.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
public class APIApplication {
    public static void main(String[] args) {
        SpringApplication.run(APIApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/travel/sendRequest"))
                .apis(RequestHandlerSelectors.basePackage("com.assignmentDemo"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Assignment Hotel availability checking API",
                "assignment work for VE find available rooms for specific location and passenger combination",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Ishan", "http://127.0.0.1:8080/swagger-ui.html", "ishan@gmail.com"),
                "API License",
                "http://127.0.0.1:8080/swagger-ui.html",
                Collections.emptyList()
        );
    }

}
