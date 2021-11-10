package com.topicospl.msadmistracion.service.imp.promocion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msadmistracion.bean.Promocion;
import com.topicospl.msadmistracion.bean.dto.PromocionDTO;
import com.topicospl.msadmistracion.exception.PromocionAlreadyExistException;
import com.topicospl.msadmistracion.exception.PromocionNotFoundException;
import com.topicospl.msadmistracion.repository.PromocionRepository;
import com.topicospl.msadmistracion.response.PromocionResponse;
import com.topicospl.msadmistracion.service.IAdministracionPromocionService;

@Service(value = "promocionFull")
public class AdministracionPromocionService implements IAdministracionPromocionService {

	@Autowired
	private PromocionRepository promocionRepository;

	@Override
	public ResponseEntity<?> getAllRecords(Boolean filter) {

		List<PromocionDTO> convert;
		
		if (filter) {
			convert = promocionRepository.findByEstado(true).stream().map(PromocionDTO::new).collect(Collectors.toList());
		}else {
			convert = promocionRepository.findAll().stream().map(PromocionDTO::new).collect(Collectors.toList());
		}
		
		var response = new PromocionResponse();
			response.setCode(String.valueOf(HttpStatus.OK.value()));
			response.setStatus(HttpStatus.OK.name());
			response.setMessage("Listado Productos con estado " + filter );
			response.setBody(new ResponseEntity<>(convert, HttpStatus.OK));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updatePromocion(PromocionDTO promocion) {
		
		var promocionByCodigo = promocionRepository.findByCodigo(promocion.getCodigo());
		
		if(promocionByCodigo.isPresent()) {
			var promo = promocionByCodigo.get();
			promo.setDetalle(promocion.getDetalle());
			promo.setEstado(promocion.getEstado());
			promo.setPorcentaje(promocion.getPorcentaje());
			
			promocionRepository.save(promo);
			
			var response = new PromocionResponse();
				response.setCode(String.valueOf(HttpStatus.OK.value()));
				response.setStatus(HttpStatus.OK.name());
				response.setMessage("Actualizacion Producto Correcta");
				response.setBody(new ResponseEntity<>(null, HttpStatus.OK));
				
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		throw new PromocionNotFoundException("La promocion con codigo -> " + promocion.getCodigo() + " no se encontro dentro del sistema");
	}

	@Override
	public ResponseEntity<?> createPromocion(PromocionDTO promocion) {
		
		var promocionByCodigo = promocionRepository.findByCodigo(promocion.getCodigo());
		
		if(promocionByCodigo.isPresent()) 
			throw new PromocionAlreadyExistException("La promocion con codigo -> " + promocion.getCodigo() + " se encuentra creada dentro del sistema");
			
		var promocionToSave = new Promocion(promocion);
			
		promocionRepository.save(promocionToSave);
		
		var response = new PromocionResponse();
			response.setCode(String.valueOf(HttpStatus.OK.value()));
			response.setStatus(HttpStatus.OK.name());
			response.setMessage("Creacion Producto Correcta");
			response.setBody(new ResponseEntity<>(null, HttpStatus.OK));
			
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<?> promocionById(Long id) {
	
		var promocionByCodigo = promocionRepository.findByCodigo(id);
		
		if(promocionByCodigo.isPresent()) {
			
			var response = new PromocionResponse();
			response.setCode(String.valueOf(HttpStatus.OK.value()));
			response.setStatus(HttpStatus.OK.name());
			response.setMessage("Busqueda Producto Correcta");
			response.setBody(new ResponseEntity<>(promocionByCodigo.get(), HttpStatus.OK));
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
			
		
		throw new PromocionNotFoundException("La promocion con codigo -> " + id + " no se encontro dentro del sistema");
	}

}
