package swe425.project.MIUScheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration

public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/css/**",
                "/fonts/**",
                "/images/**",
                "/js/**",
                "/vendor/**")
                .addResourceLocations(
                        "classpath:/static/css/",
                        "classpath:/static/fonts/",
                        "classpath:/static/images/",
                        "classpath:/static/js/",
                        "classpath:/static/vendor/");
    }
}