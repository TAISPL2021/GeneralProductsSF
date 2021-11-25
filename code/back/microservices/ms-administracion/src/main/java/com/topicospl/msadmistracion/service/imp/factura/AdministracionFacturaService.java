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
import com.topicospl.msadmistracion.bean.dto.FacturaDTO;
import com.topicospl.msadmistracion.bean.dto.PedidoDTO;
import com.topicospl.msadmistracion.proxy.AutenticacionProxyFeign;
import com.topicospl.msadmistracion.proxy.InventarioProxyFeign;
import com.topicospl.msadmistracion.proxy.PagoElectronicoProxyFeign;
import com.topicospl.msadmistracion.repository.FacturaRepository;
import com.topicospl.msadmistracion.repository.ProductoRepository;
import com.topicospl.msadmistracion.service.IAdministracionFacturaService;
import com.topicospl.msadmistracion.service.IAdministracionPedidoService;

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
	
	@Autowired
	private IAdministracionPedidoService pedidoService; 
	
	@Autowired
	private PagoElectronicoProxyFeign pagoElectronicoProxyFeign;

	private Double fullTotal;

	@Override
	public ResponseEntity<?> facturaGenerator(FacturaDTO carritoCheckOut) {
		
		fullTotal = 0D;

		var userInfo = autenticacionProxyFeign.getBy(carritoCheckOut.getCarritoCheckOut().get(0).getUserName());

		Hashtable<Long, Producto> hProducts = new Hashtable<>();
		List<Producto> listProductos = new ArrayList<>();

		carritoCheckOut.getCarritoCheckOut().forEach(value -> {

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

		@SuppressWarnings("unused")
		ResponseEntity<?> pagoResult;
		try {
			var tmpPago = carritoCheckOut.getPagoDTO();
			tmpPago.setTotal(fullTotal);
			pagoResult = pagoElectronicoProxyFeign.creditCardPayment(tmpPago, carritoCheckOut.getCarritoCheckOut().get(0).getUserName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
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
		
		// Generacion ORDENES
		pedidoService.createPedido(new PedidoDTO(
					"Abierto",
					userInfo.getBody().getName() + " " + userInfo.getBody().getLastName(),
					userInfo.getBody().getEmail(),
					userInfo.getBody().getPhone(),
					userInfo.getBody().getAddress(),
					listProductos));

		return new ResponseEntity<>(facturaGen, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> listFactura() {
		return new ResponseEntity<>(facturaRepository.findAll(),HttpStatus.OK);
	}

}
