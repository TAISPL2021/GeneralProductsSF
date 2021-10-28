package com.topicospl.msinventario.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msinventario.bean.Producto;
import com.topicospl.msinventario.bean.dto.ProductoDTO;
import com.topicospl.msinventario.exception.ProductoAlreadyExistException;
import com.topicospl.msinventario.exception.ProductoNotFoundException;
import com.topicospl.msinventario.repository.ProductoRepository;
import com.topicospl.msinventario.response.InventarioResponse;
import com.topicospl.msinventario.service.IProductoService;

@Service
public class ProductoService implements IProductoService {

	@Value("${ms.producto.img}")
	private String imgRouteURL;

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public ResponseEntity<List<ProductoDTO>> getAllRecords() {
		return new ResponseEntity<>(
				productoRepository.findAll().stream().map(ProductoDTO::new).collect(Collectors.toList()),
				HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<ProductoDTO>> getAllRecordsActive() {
		return new ResponseEntity<>(
				productoRepository.findByProductoEstado(true).stream().map(ProductoDTO::new).collect(Collectors.toList()),
				HttpStatus.OK);
	}
	

	@Override
	public ResponseEntity<List<ProductoDTO>> getRecordsBySearch(String querySearch) {
		return new ResponseEntity<>(productoRepository.findByProductoNombreLike(querySearch.toLowerCase().trim())
				.stream().map(ProductoDTO::new).collect(Collectors.toList()), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<InventarioResponse> saveRecord(ProductoDTO product) {
		var tmpProductoCode = findByProductoCode(product.getProductoCode());
		
		if(tmpProductoCode.isPresent())
			throw new ProductoAlreadyExistException("El Producto con el Codigo: ["+product.getProductoCode()+"] existe en la DB");
		 
		productoRepository.save(transformerToEntity(product));
		
		var response = new InventarioResponse();
			response.setCode(String.valueOf(HttpStatus.OK.value()));
			response.setStatus(HttpStatus.OK.name());
			response.setMessage("Creacion del Producto con codigo: [" +product.getProductoCode() +"], fue realizado con exito");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<InventarioResponse> updateRecord(ProductoDTO product) {
		
		var tmpProductoChecker = findByProductoCode(product.getProductoCode());
		
		if(tmpProductoChecker.isPresent()) {
			var tmpProducto = tmpProductoChecker.get();
							
				tmpProducto.setProductoPrecio(product.getProductoPrecio());
				tmpProducto.setProductoDetalles(product.getProductoDetalles());
				tmpProducto.setProductoDescuento(product.getProductoDescuento());
				tmpProducto.setProductoCantidadDisponible(product.getProductoCantidadDisponible());
				tmpProducto.setProductoEstado(product.getProductoEstado());

			productoRepository.save(tmpProducto);
			
			var response = new InventarioResponse();
				response.setCode(String.valueOf(HttpStatus.OK.value()));
				response.setStatus(HttpStatus.OK.name());
				response.setMessage("Actualizacion del Producto con codigo: [" +product.getProductoCode() +"], fue realizado con exito");
						
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			throw new ProductoNotFoundException("El Producto con el Codigo: ["+product.getProductoCode()+"] no se encontro en la DB");
		}
	}

	@Override
	public Optional<Producto> findByProductoCode(Long pCode) {	
		return productoRepository.findByProductoCode(pCode);
	}
	
	private Producto transformerToEntity(ProductoDTO p) {
		return Producto.builder()
				.productoCode(p.getProductoCode())
				.productoNombre(p.getProductoNombre())
				.productoPrecio(p.getProductoPrecio())
				.productoDetalles(p.getProductoDetalles())
				.productoEstado(p.getProductoEstado() == null ? false : p.getProductoEstado())
				.productoDescuento(p.getProductoDescuento() == null ? 0 : p.getProductoDescuento())
				.productoImg(p.getProductoImg() == null ? imgRouteURL : p.getProductoImg())
				.productoFechaInclusion(new Date())
				.productoCantidadDisponible(p.getProductoCantidadDisponible() == null ? 0 : p.getProductoCantidadDisponible())
			.build();
	}


	
}