package com.topicospl.msinventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInventarioApplication.class, args);
	}
 
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("*")
//						.allowedMethods("GET","POST,","PUT","PATCH","OPTIONS");
//			}
//		};
//	}
}
