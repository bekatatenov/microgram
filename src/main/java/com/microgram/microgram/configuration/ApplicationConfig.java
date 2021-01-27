package com.microgram.microgram.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/***
 * В общем, мы здесь минимально настраиваем Swagger 2 и подключаем его к нашему API
 * Не вдавайтесь пока сильно в подробности
 * Но если вы захотите подключить Swagger к вашему проекту, то вам понадобится повторить
 * всё тоже самое.
 *
 * Так же обратите внимание на аннотацию ApiPageable, и её использование
 * это "костыль" для починки проблемы связанной с неверным определением
 * имён параметров для Pageable в проектах Spring
 */


@Configuration
@EnableSwagger2
@EnableSpringDataWebSupport
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket productApi() {
        // настраиваем Swagger 2
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.microgram.microgram.controller"))
                .paths(regex("/.*"))
                .build();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // добавим авто-обработку параметров Pageable и Sortable для наших контроллеров
        argumentResolvers.add( new PageableHandlerMethodArgumentResolver());
        argumentResolvers.add( new SortHandlerMethodArgumentResolver());
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // регистрируем путь к интерфейсу Swagger
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
