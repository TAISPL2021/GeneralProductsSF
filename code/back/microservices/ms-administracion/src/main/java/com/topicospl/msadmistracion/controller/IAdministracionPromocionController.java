package com.topicospl.msadmistracion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topicospl.msadmistracion.bean.dto.PromocionDTO;

@RequestMapping("/administracion")
public interface IAdministracionPromocionController {

	@GetMapping("/promocion")
	public ResponseEntity<?> promocionList(@RequestHeader("filter") Boolean filter);
	
	@GetMapping("/promocion/{id}")
	public ResponseEntity<?> promocionById(@PathVariable Long id);
	
	@PostMapping("/promocion")
	public ResponseEntity<?> promicionGenerator(@RequestBody PromocionDTO promocion);
	
	@PutMapping("/promocion")
	public ResponseEntity<?> updatePromocion(@RequestBody PromocionDTO promocion);
}
