package lion.like.galleryapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 서버의 모든 API를 모든 도메인에서 접속할 수 있도록 허용
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}