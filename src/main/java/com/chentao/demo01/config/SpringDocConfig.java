package com.chentao.demo01.config;



import com.chentao.demo01.constant.SwaggerProperties;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Autowired
    SwaggerProperties swaggerProperties;
    @Bean
    public OpenAPI myOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(swaggerProperties.getApplicationName())
                        .description(swaggerProperties.getApplicationDescription())
                        .version(swaggerProperties.getApplicationVersion())
                        .license(new License()
                                .name("许可协议")
                                .url("https://felixchen.top"))
                        .contact(new Contact()
                                .name("Felix Chen")
                                .email("felixchentao@163.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("FelixChen的博客")
                        .url("https://felixchengao.top"));
    }
}