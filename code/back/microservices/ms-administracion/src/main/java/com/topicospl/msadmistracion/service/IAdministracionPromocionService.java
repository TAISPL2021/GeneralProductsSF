package com.topicospl.msadmistracion.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.topicospl.msadmistracion.bean.dto.PromocionDTO;

public interface IAdministracionPromocionService {

	public ResponseEntity<List<PromocionDTO>> getAllRecords(Boolean filter);
	public ResponseEntity<?> updatePromocion(PromocionDTO promocion);
	public ResponseEntity<?> createPromocion(PromocionDTO promocion);
}
