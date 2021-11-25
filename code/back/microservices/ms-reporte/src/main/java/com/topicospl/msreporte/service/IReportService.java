package com.topicospl.msreporte.service;


import com.topicospl.msreporte.bean.dto.OrdersReportDTO;
import com.topicospl.msreporte.bean.dto.ProductsReportsDTO;
import com.topicospl.msreporte.bean.dto.PromReportsDTO;

import java.util.List;

public interface IReportService {

	List<ProductsReportsDTO> getListProductosFromInventario(boolean monthly);
	List<PromReportsDTO> getListPromFromInventario(boolean monthly);
	List<OrdersReportDTO> getListOrders(boolean monthly);

}
