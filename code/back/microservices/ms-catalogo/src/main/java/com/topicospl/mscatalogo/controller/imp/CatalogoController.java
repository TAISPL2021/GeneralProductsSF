package com.topicospl.mscatalogo.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.topicospl.mscatalogo.bean.dto.ProductoDTO;
import com.topicospl.mscatalogo.controller.ICatalogoController;
import com.topicospl.mscatalogo.service.ICatalogoService;

@RestController
public class CatalogoController implements ICatalogoController{

	@Autowired
	private ICatalogoService catalogoService;
	
	@Override
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventario() {
		return catalogoService.getListProductosFromInventario();
	}

	@Override
	public ResponseEntity<List<ProductoDTO>> getListProductosFromInventarioByLike(String query) {
		return catalogoService.getListProductosFromInventarioByLike(query);
	}

}
