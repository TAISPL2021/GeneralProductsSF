package com.topicospl.msreporte.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reporte")
public interface IReportController {
    @GetMapping("/promocion")
    ResponseEntity<?>  getPromReport(@RequestHeader boolean monthly);

    @GetMapping("/orden")
    ResponseEntity<?> getOrderReport(@RequestHeader boolean monthly);

    @GetMapping("/producto")
    ResponseEntity<?> getProductReport(@RequestHeader boolean monthly);
}
