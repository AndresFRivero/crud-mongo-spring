package com.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.entity.UserEntity;
import com.mongo.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/mongo")
@Tag(name = "User API", description = "Controlador para acceder a metodos de interaccion con los datos de BD")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Tag(name = "Consultas", description = "Consultas de User API")
	@GetMapping("/findAll")
	public List<UserEntity> findAll() {
		return this.userService.findAll();
	}
	
	//@Tag(name = "Operaciones", description = "Operaciones de User API")
	@Operation(summary = "Registra un usuario", tags = {"Operaciones", "POST"})
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody UserEntity userEntity) {
		return ResponseEntity.ok(this.userService.save(userEntity));
	}
	
	//@Tag(name = "Operaciones", description = "Operaciones de User API")
	@Operation(summary = "Actualiza un usuario", tags = {"Operaciones", "PUT"})
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody UserEntity userEntity) {
		this.userService.update(id, userEntity);
		
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	//@Tag(name = "Operaciones", description = "Operaciones de User API")
	@Operation(summary = "Registra un usuario", tags = {"Operaciones", "DELETE"})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		return ResponseEntity.ok(this.userService.delete(id));
	}
}
