package io.sveltespring.svelteboot;

import java.time.Duration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("app");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/signin").setViewName("signin");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/_app/**")
                .addResourceLocations("classpath:/static/build/_app/")
                .setCacheControl(CacheControl.maxAge(Duration.ofMillis(365)));

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/build/")
                .setCacheControl(CacheControl.noCache());
    }

    // docs: https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-config/static-resources.html
}
