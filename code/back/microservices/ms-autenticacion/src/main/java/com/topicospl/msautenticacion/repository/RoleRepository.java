package com.topicospl.msautenticacion.repository;

import com.topicospl.msautenticacion.bean.Role;
import com.topicospl.msautenticacion.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByRoleName(RoleName roleName);
}
