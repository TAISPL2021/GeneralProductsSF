package com.topicospl.msadmistracion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topicospl.msadmistracion.bean.dto.PromocionDTO;

@RequestMapping("/administracion")
public interface IAdministracionPromocionController {

	@GetMapping("/promocion")
	public ResponseEntity<List<PromocionDTO>> promocionList(@RequestHeader("filter") Boolean filter);
	
	@PostMapping("/promocion")
	public ResponseEntity<?> promicionGenerator();
	
	@PutMapping("/promocion")
	public ResponseEntity<?> updatePromocion(@RequestBody PromocionDTO promocion);
}
