package com.topicospl.msinventario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.topicospl.msinventario.bean.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	@Query("select p from Producto p where lower(p.productoNombre) LIKE CONCAT('%',:username,'%')")
	List<Producto> findByProductoNombreLike(@Param("username") String querySearch);

	Optional<Producto> findByProductoCode(Long productoCode);
	
	List<Producto> findByProductoEstado(Boolean productoEstado);

}
