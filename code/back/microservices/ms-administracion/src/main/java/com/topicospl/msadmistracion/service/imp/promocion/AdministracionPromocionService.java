package com.topicospl.msadmistracion.service.imp.promocion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msadmistracion.bean.dto.PromocionDTO;
import com.topicospl.msadmistracion.repository.PromocionRepository;
import com.topicospl.msadmistracion.service.IAdministracionPromocionService;

@Service(value = "promocionFull")
public class AdministracionPromocionService implements IAdministracionPromocionService {

	@Autowired
	private PromocionRepository promocionRepository;

	@Override
	public ResponseEntity<List<PromocionDTO>> getAllRecords(Boolean filter) {

		List<PromocionDTO> convert;
		
		if (filter) {
			convert = promocionRepository.findByEstado(true).stream().map(PromocionDTO::new).collect(Collectors.toList());
		}else {
			convert = promocionRepository.findAll().stream().map(PromocionDTO::new).collect(Collectors.toList());
		}
			
		return new ResponseEntity<>(convert, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PromocionDTO> updatePromocion(PromocionDTO promocion) {
		
		var promocionByCodigo = promocionRepository.findByCodigo(promocion.getCodigo());
		
		if(promocionByCodigo.isPresent()) {
			var promo = promocionByCodigo.get();
			promo.setDetalle(promocion.getDetalle());
			promo.setEstado(promocion.getEstado());
			promo.setPorcentaje(promocion.getPorcentaje());
			
			promocionRepository.save(promo);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		
		throw new RuntimeException();
	}

	@Override
	public ResponseEntity<?> createPromocion(PromocionDTO promocion) {
		// TODO Auto-generated method stub
		return null;
	}

}
