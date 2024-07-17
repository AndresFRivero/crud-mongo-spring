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

@RestController
@RequestMapping("/api/mongo")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/findAll")
	public List<UserEntity> findAll() {
		return this.userService.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody UserEntity userEntity) {
		return ResponseEntity.ok(this.userService.save(userEntity));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody UserEntity userEntity) {
		this.userService.update(id, userEntity);
		
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id){
		return ResponseEntity.ok(this.userService.delete(id));
	}
}
