package com.topicospl.msreporte.service.imp;


import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.topicospl.msreporte.bean.Factura;
import com.topicospl.msreporte.bean.Producto;
import com.topicospl.msreporte.bean.dto.OrdersReportDTO;
import com.topicospl.msreporte.proxy.AdminProxy;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.topicospl.msreporte.bean.ProductoDTO;
import com.topicospl.msreporte.bean.PromocionDTO;
import com.topicospl.msreporte.bean.dto.ProductsReportsDTO;
import com.topicospl.msreporte.bean.dto.PromReportsDTO;
import com.topicospl.msreporte.proxy.ProductProxy;
import com.topicospl.msreporte.service.IReportService;

@Service
public class ReportService implements IReportService {
	
	@Autowired
	private ProductProxy reporteProxy;
	@Autowired
	private AdminProxy promocionProxy;

	private ModelMapper modelMapper = new ModelMapper();
	Date date = new Date();
	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	int month = localDate.getMonthValue();

	@Override
	public  List<ProductsReportsDTO> getListProductosFromInventario(boolean monthly) {
		List<ProductoDTO> products = reporteProxy.getListProductosFromInventario().getBody();
		List<ProductoDTO> productsReport = new ArrayList<>();
		if(monthly){
			productsReport = products.stream()
					.filter(product -> product.getProductoFechaInclusion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue() == month)
					.collect(Collectors.toList());
			}
		else{
			productsReport = products.stream()
					.filter(product -> product.getProductoFechaInclusion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() == localDate.getYear())
					.collect(Collectors.toList());
		}

		Type listType = new TypeToken<List<ProductsReportsDTO>>() {
		}.getType();
		List<ProductsReportsDTO> report = modelMapper.map(productsReport, listType);
		return report;
	}

	@Override
	public List<PromReportsDTO> getListPromFromInventario(boolean monthly) {
		List<PromocionDTO> prom = (List<PromocionDTO>) promocionProxy.getListPromFromInventario(false).getBody();
		Type listType = new TypeToken<List<PromReportsDTO>>() {
		}.getType();
		List<PromReportsDTO> report = modelMapper.map(prom, listType);
	return report;
	}

	@Override
	public List<OrdersReportDTO> getListOrders(boolean monthly) {
		List<Factura> listFacturas = Arrays.asList(modelMapper.map(promocionProxy.listFactura().getBody(),Factura[].class)) ;
		 List<OrdersReportDTO> listOrders = new ArrayList<>();
		List<Producto> productosAdd = new ArrayList<>();
		for (Factura listFac:listFacturas ) {
			for (Producto prod:listFac.getProductos() ) {
				if (!productosAdd.contains(prod)) {
					OrdersReportDTO order = new OrdersReportDTO();
					order.setFacturaCodigo(listFac.getFacturaCodigo());
					order.setFacturaFecha(listFac.getFacturaFecha());
					order.setFacturaNombreCliente(listFac.getFacturaNombreCliente());
					order.setCantidad(1);
					order.setNombreProduct(prod.getProductoNombre());
					order.setPriceProducto(prod.getProductoPrecio());
					order.setProductId(prod.getProductoCode());
					listOrders.add(order);
					System.out.println("hola");
				} else {
					for (OrdersReportDTO orders : listOrders) {
						if (orders.getProductId() == prod.getId()) {
							orders.setCantidad(orders.getCantidad() + 1);
						}
					}
				}
			}
		}
		return listOrders;
	}

}
