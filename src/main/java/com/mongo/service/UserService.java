package com.mongo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.entity.UserEntity;
import com.mongo.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	IUserRepository userRepository;
	
	public List<UserEntity> findAll(){
		return this.userRepository.findAll();
	}
	
	public UserEntity save(UserEntity userEntity) {
		userEntity.setDateRegister(LocalDateTime.now());
		return this.userRepository.save(userEntity);
	}
	
	public void update(String id, UserEntity userEntity) {
		
		UserEntity user = this.userRepository.findById(id).orElse(null);
		
		if (user != null) {
			user.setName(userEntity.getName());
			user.setLastname(userEntity.getLastname());
			user.setAge(userEntity.getAge());
			user.setGender(userEntity.getGender());
			user.setDateRegister(LocalDateTime.now());
			this.userRepository.save(user);
		}
		
	}
	
	public UserEntity delete(String id) {
		UserEntity user = this.userRepository.findById(id).orElse(null);
		
		if (user != null) {			
			this.userRepository.delete(user);
		}
		
		return user;
	}

}
