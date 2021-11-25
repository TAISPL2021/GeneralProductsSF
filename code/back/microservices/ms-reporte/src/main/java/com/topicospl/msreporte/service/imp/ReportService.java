package com.topicospl.msreporte.service.imp;


import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicospl.msreporte.bean.ProductoDTO;
import com.topicospl.msreporte.bean.PromocionDTO;
import com.topicospl.msreporte.bean.dto.ProductsReportsDTO;
import com.topicospl.msreporte.bean.dto.PromReportsDTO;
import com.topicospl.msreporte.proxy.ProductProxy;
import com.topicospl.msreporte.proxy.PromocionProxy;
import com.topicospl.msreporte.service.IReportService;

@Service
public class ReportService implements IReportService {
	
	@Autowired
	private ProductProxy reporteProxy;
	@Autowired
	private PromocionProxy promocionProxy;

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

}
