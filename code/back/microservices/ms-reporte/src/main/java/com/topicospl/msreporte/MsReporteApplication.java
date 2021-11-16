package com.topicospl.msreporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsReporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsReporteApplication.class, args);
	}

}
