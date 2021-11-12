package com.topicospl.mscatalogo.service.imp;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.andrewoma.dexx.collection.HashMap;
import com.topicospl.mscatalogo.bean.Carrito;
import com.topicospl.mscatalogo.bean.dto.CarritoInDTO;
import com.topicospl.mscatalogo.bean.dto.CarritoOutDTO;
import com.topicospl.mscatalogo.bean.dto.CarritoProductoDTO;
import com.topicospl.mscatalogo.repository.CarritoRepository;
import com.topicospl.mscatalogo.service.ICarritoService;

@Service
public class CarritoService implements ICarritoService {

	@Autowired
	private CarritoRepository carritoRepository;

	@Override
	public ResponseEntity<?> statusCarrito(String userName) {
		var statusProductosInCarrito = carritoRepository.findByUserName(userName);

		return new ResponseEntity<>(statusProductosInCarrito, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> incluirCarrito(CarritoInDTO carrito) {

		Hashtable<Long, CarritoProductoDTO> hProducts = new Hashtable<>();

		carritoRepository.save(new Carrito(carrito));
		var listCarrito = carritoRepository.findByUserName(carrito.getUserName());
		
		var carritoViewOut = new CarritoOutDTO();
		carritoViewOut.setUserName(carrito.getUserName());
		carritoViewOut.setFecha(listCarrito.size() < 0 ? null : listCarrito.get(0).getFechaCarrito());

		listCarrito.forEach(value -> {

			if(hProducts.containsKey(value.getProductoCode())) {
				var tempProducto = hProducts.get(value.getProductoCode());
				tempProducto.setProductoCantidadComprar(tempProducto.getProductoCantidadComprar() + carrito.getProductoCantidadComprar());
				hProducts.put(value.getProductoCode(), tempProducto);
				
			}else {
				hProducts.put(value.getProductoCode(), new CarritoProductoDTO(value.getProductoNombre(),
						value.getProductoDetalle(), value.getProductoCantidadComprar()));
			}
			
		});
		
		carritoViewOut.setProductos(hProducts);

		return new ResponseEntity<>(carritoViewOut, HttpStatus.OK);
	}

}
