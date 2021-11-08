package com.topicospl.msadmistracion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topicospl.msadmistracion.bean.Promocion;
import java.lang.Boolean;
import java.util.List;

@Repository
public interface PromocionRepository extends JpaRepository<Promocion, Long>{

	Optional<Promocion> findByCodigo(Long codigo);
	
	List<Promocion> findByEstado(Boolean estado);
}
