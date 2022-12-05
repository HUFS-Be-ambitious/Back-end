//package hufs.capstone.demo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MvcConfig implements WebMvcConfigurer{
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new InterceptorConfig())
//                .order(0)
//                //적용할 url
//                .addPathPatterns("/**")
//                //제외할 url
//                .excludePathPatterns("/member/login" ,"/member/login/add","/member/find-all","/css/**", "/*.ico", "/error");
//    }
//    @Bean
//    public InterceptorConfig interceptorConfig(){
//        return new InterceptorConfig();
//    }
//}
