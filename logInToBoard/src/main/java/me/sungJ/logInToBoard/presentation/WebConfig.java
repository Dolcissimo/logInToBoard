package me.sungJ.logInToBoard.presentation;

import me.sungJ.logInToBoard.presentation.auth.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/posts/**")    // 보호 구간
                .excludePathPatterns(
                        "/", "/login", "/logout",
                        "/login-success", "/error",



                        "/css/**", "/js/**", "/images/**", "/webjars/**"
                );
    }
}
