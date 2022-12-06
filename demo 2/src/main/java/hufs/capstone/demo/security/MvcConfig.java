package hufs.capstone.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
    //설정
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
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
