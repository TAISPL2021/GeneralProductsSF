package com.topicospl.msadmistracion.service.imp.factura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msadmistracion.bean.Factura;
import com.topicospl.msadmistracion.bean.Producto;
import com.topicospl.msadmistracion.bean.dto.CarritoDTO;
import com.topicospl.msadmistracion.proxy.AutenticacionProxyFeign;
import com.topicospl.msadmistracion.proxy.InventarioProxyFeign;
import com.topicospl.msadmistracion.repository.FacturaRepository;
import com.topicospl.msadmistracion.repository.ProductoRepository;
import com.topicospl.msadmistracion.service.IAdministracionFacturaService;

@Service
public class AdministracionFacturaService implements IAdministracionFacturaService {

	@Autowired
	private InventarioProxyFeign inventarioProxyFeign;

	@Autowired
	private AutenticacionProxyFeign autenticacionProxyFeign;

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private ProductoRepository productoRepository;

	private Double fullTotal;

	@Override
	public ResponseEntity<?> facturaGenerator(List<CarritoDTO> carritoCheckOut) {

		fullTotal = 0D;

		var userInfo = autenticacionProxyFeign.getBy(carritoCheckOut.get(0).getUserName());

		Hashtable<Long, Producto> hProducts = new Hashtable<>();
		List<Producto> listProductos = new ArrayList<>();

		carritoCheckOut.forEach(value -> {

			var productPrice = inventarioProxyFeign.findByCode(value.getProductoCode()).getBody();

			if (hProducts.containsKey(value.getProductoCode())) {
				var tmpPro = hProducts.get(value.getProductoCode());
				tmpPro.setProductoCantidad(tmpPro.getProductoCantidad() + value.getProductoCantidadComprar());
				tmpPro.setTotal(tmpPro.getProductoCantidad() * tmpPro.getProductoPrecio());
				hProducts.put(value.getProductoCode(), tmpPro);
			} else {
				var tmpProduct = new Producto();
				tmpProduct.setProductoCode(value.getProductoCode());
				tmpProduct.setProductoNombre(value.getProductoNombre());
				tmpProduct.setProductoDetalle(value.getProductoDetalle());
				tmpProduct.setProductoPrecio(productPrice.getProductoPrecio());
				tmpProduct.setProductoCantidad(value.getProductoCantidadComprar());
				tmpProduct.setTotal(tmpProduct.getProductoPrecio() * tmpProduct.getProductoCantidad());
				hProducts.put(value.getProductoCode(), tmpProduct);
			}

		});

		hProducts.forEach((k, v) -> {
			fullTotal += v.getTotal();
			listProductos.add(v);

		});

		var facturaIdGen = 1L + (Math.random() * (1000000000L - 1L));
		var facturaGen = new Factura();
		facturaGen.setFacturaCodigo((long) facturaIdGen);
		facturaGen.setFacturaFecha(LocalDate.now());
		facturaGen.setFacturaNombreCliente(userInfo.getBody().getName() + " " + userInfo.getBody().getLastName());
		facturaGen.setFacturaCorreoCliente(userInfo.getBody().getEmail());
		facturaGen.setFacturaDireccionCliente(userInfo.getBody().getAddress());
		facturaGen.setProductos(listProductos);
		facturaGen.setFacturaTotal(fullTotal);

		listProductos.forEach(v -> productoRepository.save(v));

		facturaGen = facturaRepository.save(facturaGen);

		return new ResponseEntity<>(facturaGen, HttpStatus.OK);
	}

}
