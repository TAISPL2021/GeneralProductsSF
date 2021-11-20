package com.topicospl.mscatalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topicospl.mscatalogo.bean.Carrito;

import feign.Param;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

	List<Carrito> findByUserName(String username);
	
	List<Carrito> findByCarritoId(Long carritoId);
	
	@Transactional
	@Modifying
	@Query("delete from Carrito c where c.carritoId=:id")
	void removeCacheCarrito(@Param("id") Long id);
}
