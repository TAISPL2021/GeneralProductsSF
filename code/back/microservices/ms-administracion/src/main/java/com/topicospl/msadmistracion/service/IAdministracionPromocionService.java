package com.topicospl.msadmistracion.service;

import org.springframework.http.ResponseEntity;

import com.topicospl.msadmistracion.bean.dto.PromocionDTO;

public interface IAdministracionPromocionService {

	public ResponseEntity<?> getAllRecords(Boolean filter);
	public ResponseEntity<?> updatePromocion(PromocionDTO promocion);
	public ResponseEntity<?> createPromocion(PromocionDTO promocion);
	public ResponseEntity<?> promocionById(Long id);
}
