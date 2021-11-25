package com.topicospl.msadmistracion.service.imp.promocion;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msadmistracion.bean.dto.PromocionDTO;
import com.topicospl.msadmistracion.service.IAdministracionPromocionService;

@Service(value = "promocionGeneric")
public class AdministracionPromocionGenericService implements IAdministracionPromocionService{

	@Override
	public ResponseEntity<?> updatePromocion(PromocionDTO promocion) {
		return new ResponseEntity<>(null,HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<List<PromocionDTO>> getAllRecords(int filter) {
		return new ResponseEntity<>(null,HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<?> createPromocion(PromocionDTO promocion) {
		return new ResponseEntity<>(null,HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<?> promocionById(Long id) {
		return new ResponseEntity<>(null,HttpStatus.NOT_IMPLEMENTED);
	}

}
