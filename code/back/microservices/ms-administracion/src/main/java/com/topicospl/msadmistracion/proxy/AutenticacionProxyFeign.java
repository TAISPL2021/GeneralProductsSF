package com.topicospl.msadmistracion.proxy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.topicospl.msadmistracion.bean.User;
import com.topicospl.msadmistracion.bean.dto.UserDTO;

@FeignClient(value = "ms-autenticacion" , url = "http://localhost:5000/autenticacion")
public interface AutenticacionProxyFeign {

	@DeleteMapping("/eliminar")
	public ResponseEntity<?> delete(@Valid @RequestBody UserDTO user);
	
    @GetMapping("/users")
    public List<User> getAll();
}
