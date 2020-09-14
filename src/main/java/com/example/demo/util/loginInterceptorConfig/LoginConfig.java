package com.example.demo.util.loginInterceptorConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 登陆拦截器配置
 * @author lining
 * @date 2020/08/03
 *
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册TestInterceptor拦截器
		InterceptorRegistration registration = registry.addInterceptor(new LoginHandlerInterceptor());
		registration.addPathPatterns("/**"); // 所有路径都被拦截
		registration.excludePathPatterns( // 添加不拦截路径
				"/**/*.html", // html静态资源
				"/**/*.js", // js静态资源
				"/**/*.css", // css静态资源
				"/**/*.jpg",
				"/**/*.png",
				"/**/*.woff", 
				"/**/*.ttf",
				"/**/*.gif", 
				"/**/*.json",
				"/login","/userLogin", "/loginOut","/user/login","/user/add");
	}
}
