package com.topicospl.msautenticacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MsAutenticacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAutenticacionApplication.class, args);
	}
}
