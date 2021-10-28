package com.topicospl.msautenticacion.service;

import com.topicospl.msautenticacion.bean.Role;
import com.topicospl.msautenticacion.enums.RoleName;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    List<Role> getRoles();
    Optional<Role> findByRoleName (RoleName roleName);
    Role save (Role role);
}
