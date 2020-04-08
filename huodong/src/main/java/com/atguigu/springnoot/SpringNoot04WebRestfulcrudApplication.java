package com.atguigu.springnoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Locale;

@SpringBootApplication
@MapperScan("com.atguigu.springnoot.mapper")
public class SpringNoot04WebRestfulcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNoot04WebRestfulcrudApplication.class, args);
	}
	

	@Bean
	public static ViewResolver myViewResolver(){
		return new MyViewResolver();
	}
	public static class MyViewResolver implements ViewResolver{

		@Nullable
		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}
}
