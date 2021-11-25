package com.topicospl.msreporte.controller.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.google.inject.spi.Message;
import com.topicospl.msreporte.bean.dto.ProductsReportsDTO;
import com.topicospl.msreporte.bean.dto.PromReportsDTO;
import com.topicospl.msreporte.controller.IReportController;
import com.topicospl.msreporte.service.IReportService;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class ReportController implements IReportController {
    @Autowired
    IReportService reportService;

    @Override
    public ResponseEntity<?> getPromReport(boolean monthly) {
        List<PromReportsDTO> listPromFromInventario = reportService.getListPromFromInventario(monthly);
        return (listPromFromInventario.isEmpty())? new ResponseEntity<>(new Message("No hay promociones en el inventario"), HttpStatus.BAD_REQUEST): new ResponseEntity<>(listPromFromInventario, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> getOrderReport(boolean monthly) {
        return null;
    }

    @Override
    public ResponseEntity<?>getProductReport(boolean monthly) {
        List<ProductsReportsDTO> listProductosFromInventario = reportService.getListProductosFromInventario(monthly);
        return (listProductosFromInventario.isEmpty())? new ResponseEntity<>(new Message("No hay productos en el inventario"), HttpStatus.BAD_REQUEST): new ResponseEntity<>(listProductosFromInventario, HttpStatus.OK);
    }
}
