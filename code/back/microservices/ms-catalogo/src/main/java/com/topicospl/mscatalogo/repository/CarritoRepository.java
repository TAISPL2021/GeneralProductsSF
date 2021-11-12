package com.topicospl.mscatalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topicospl.mscatalogo.bean.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {

	List<Carrito> findByUserName(String username);
	
}
