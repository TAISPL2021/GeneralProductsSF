package com.topicosplmspagoelectronico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class MsPagoelectronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPagoelectronicoApplication.class, args);
	}

}
