package com.keveon.architecture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Keveon on 2017/2/23.
 * Swagger2 配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	private static final String SWAGGER_SCAN_BASE_PACKAGE = "com.keveon.architecture.rest";
	private static final String VERSION = "1.0.0";

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("使用SpringBoot为基础, 搭建的一个多模块的脚手架.项目中使用Swagger2展示RESTful APIs")
				.description("查看源码及更多内容请关注：https://github.com/Keveon/multi-module-architecture")
				.termsOfServiceUrl("https://github.com/Keveon/multi-module-architecture")
				.contact("Keveon")
				.version(VERSION)
				.build();
	}
}