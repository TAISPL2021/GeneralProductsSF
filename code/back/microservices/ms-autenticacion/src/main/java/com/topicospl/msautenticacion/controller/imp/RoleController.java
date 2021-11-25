package com.topicospl.msautenticacion.controller.imp;

import com.topicospl.msautenticacion.bean.Role;
import com.topicospl.msautenticacion.controller.IRoleController;
import com.topicospl.msautenticacion.enums.RoleName;
import com.topicospl.msautenticacion.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class RoleController implements IRoleController {

    @Autowired
    IRoleService iRoleService;

    @Override
    public List<Role> getRoles() {
        return iRoleService.getRoles();
    }

    @Override
    public Role createRole(@PathVariable String role){
        Role role1 = new Role();
        System.out.println("entre");
        if(role.equals("user")) {
            role1 = iRoleService.save(Role.builder()
                    .roleName(RoleName.USER)
                    .build());
        }

        if(role.equals("admin")){
            System.out.println("entre");
            role1 = iRoleService.save(Role.builder()
                    .roleName(RoleName.ADMIN)
                    .build());
        }
        return role1;
    }


}
