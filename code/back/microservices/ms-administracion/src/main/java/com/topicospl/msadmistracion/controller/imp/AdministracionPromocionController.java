package com.topicospl.msadmistracion.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.msadmistracion.bean.dto.PromocionDTO;
import com.topicospl.msadmistracion.controller.IAdministracionPromocionController;
import com.topicospl.msadmistracion.service.IAdministracionPromocionService;

@RestController
public class AdministracionPromocionController implements IAdministracionPromocionController {

	@Autowired
	@Qualifier(value = "promocionFull")
	private IAdministracionPromocionService promocionService;
	
	@Override
	public ResponseEntity<?> promicionGenerator() {
		return null;
	}

	@Override
	public ResponseEntity<List<PromocionDTO>> promocionList(Boolean filter) {
		return promocionService.getAllRecords(filter);
	}

	@Override
	public ResponseEntity<?> updatePromocion(PromocionDTO promocion) {
		return promocionService.updatePromocion(promocion);
	}

}
