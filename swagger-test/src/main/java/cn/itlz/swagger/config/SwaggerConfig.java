package cn.itlz.swagger.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Liuzd QQ：77822013  2019/3/31 0031
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  /*  @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("对外开放接口API 文档")
                .description("HTTP对外开放接口")
                .version("1.0.0")
                .termsOfServiceUrl("http://localhost:8080")
                .license("LICENSE")
                .licenseUrl("http://localhost:8080")
                .build();
    }*/


}
