package com.topicospl.msadmistracion.proxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.topicospl.msadmistracion.bean.User;
import com.topicospl.msadmistracion.bean.dto.UserDTO;

@FeignClient(value = "ms-autenticacion" , url = "http://msautenticacion-env.eba-fk9p9ffv.us-east-1.elasticbeanstalk.com/autenticacion")
public interface AutenticacionProxyFeign {

	@DeleteMapping("/eliminar")
	public ResponseEntity<?> delete(@Valid @RequestBody UserDTO user);
	
    @GetMapping("/users")
    public List<User> getAll();
    
    @GetMapping("/users/{uName}")
    public ResponseEntity<User> getBy(@PathVariable("uName") String uName);
}
