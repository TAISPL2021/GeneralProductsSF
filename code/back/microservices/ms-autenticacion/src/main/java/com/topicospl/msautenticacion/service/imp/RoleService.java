package com.topicospl.msautenticacion.service.imp;

import com.topicospl.msautenticacion.bean.Role;
import com.topicospl.msautenticacion.enums.RoleName;
import com.topicospl.msautenticacion.repository.RoleRepository;
import com.topicospl.msautenticacion.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findByRoleName (RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role save (Role role){
        roleRepository.save(role);
        return role;
    }
}
