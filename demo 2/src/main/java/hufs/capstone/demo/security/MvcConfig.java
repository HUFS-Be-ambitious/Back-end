package hufs.capstone.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
  @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorConfig())
                .order(0)
                //적용할 url
                .addPathPatterns("/itempost/write", "/deliverypost/write","/itempost/update/**",
                        "/deliverypost/update/**", "/itempost/delete", "/deliverypost/delete",
                        "/member/mod/**", "/member/login/delete", "/member/mannerscore/**")
                //제외할 url
                .excludePathPatterns("/member/login" ,"/member/login/add","/member/find-all","/css/**", "/*.ico", "/error",
                        "/**", "/itempost/list/**", "/deliverypost/list/**");
    }
    @Bean
    public InterceptorConfig interceptorConfig(){
        return new InterceptorConfig();
    }
}
