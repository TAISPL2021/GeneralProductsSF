package com.topicospl.msadmistracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topicospl.msadmistracion.bean.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
