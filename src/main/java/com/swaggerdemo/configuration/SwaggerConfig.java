package com.swaggerdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2  // Enable Swagger 2 Support
// JSON Format: http://localhost:8081/v2/api-docs
// Swagger UI: http://localhost:8081/swagger-ui.html
// Swagger Bootstrap UI: http://localhost:8081/doc.html
public class SwaggerConfig {

    @Bean
    /* A Springfox Docket instance provides the primary API configuration
     * with sensible defaults and convenience methods for configuration.
     */
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()  // Return the ApiSelectorBuilder Instance
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.swaggerdemo.controller"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiEndPointsInfo());
    }

    /*ApiInfo Object initialized with Information about designated API*/
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot RESTful API Demo with Swagger 2")
                .description("Simple Products Management RESTful API")
                .contact(new Contact("Karaya_12", "https://github.com/Karaya-12", "karaya.ausf.12@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
