package com.topicospl.msinventario.controller.imp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeat {

	@GetMapping("/")
	public String heartBeat() {
		return "Working!";
	}
}
