package com.topicospl.msautenticacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topicospl.msautenticacion.bean.Role;
import com.topicospl.msautenticacion.enums.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByRoleName(RoleName roleName);
}
