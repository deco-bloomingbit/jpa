package com.hd.junction.common;

import io.swagger.models.auth.In;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

/**
 * packageName: com.hd.junction.common
 * fileName: SwaggerConfigure
 * author: deco
 * date: 2023/05/09
 * description
 * ===========================================================
 * DATE         AUTHOR          NOTE
 * -----------------------------------------------------------
 * 2023/05/09      deco         최초 생성
 * ===========================================================
 */
@Configuration
public class SwaggerConfigure implements WebMvcConfigurer {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HD Junction")
                .version("HOME WORK")
                .description("HD Junction API Document")
                .license("copyright all rights reserved. HD Junction")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(headerAuthorization()))
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.hd.junction"))
                .build();
    }

    /**
     * API 접근시 제한조건
     * @return
     */
    private SecurityContext securityContext() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;

        return SecurityContext.builder()
                .securityReferences(Arrays.asList(new SecurityReference("Authorization", authorizationScopes)))
                .build();
    }

    /**
     * JWT 입력 추가
     * @return
     */
    private ApiKey headerAuthorization() {
        return new ApiKey("Authorization", HttpHeaders.AUTHORIZATION, In.HEADER.name());
    }

    /**
     * Route 추가 (No mapping for GET /swagger-ui/index.html)
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }
}