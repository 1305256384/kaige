package com.kai.edu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class swagger2Config {

    //显示所有的controller
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .build();
    }

//构建 api文档的详细信息函数,注意这里的注解引用的是哪个

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("测试")
                .description("本文档描述了接口定义")
                .version("1.0")
                .contact(new Contact("Helen", "http://kai.com", "55317332@qq.com"))
                .build();
    }
}
