package com.topicospl.msreporte.controller;

import com.topicospl.msreporte.bean.dto.OrdersReportDTO;
import com.topicospl.msreporte.bean.dto.ProductsReportsDTO;
import com.topicospl.msreporte.bean.dto.PromReportsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reporte")
public interface IReportController {
    @GetMapping("/promocion")
    ResponseEntity<?>  getPromReport(@RequestHeader boolean monthly);

    @GetMapping("/orden")
    ResponseEntity<?> getOrderReport(@RequestHeader boolean monthly);

    @GetMapping("/producto")
    ResponseEntity<?> getProductReport(@RequestHeader boolean monthly);
}
