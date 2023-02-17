package My_moon_period_tracker.demo.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;


@Configuration
public class SpringGlobalConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings (CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "OPTIONS", "PATCH")
                .allowCredentials(true);

    }
}
