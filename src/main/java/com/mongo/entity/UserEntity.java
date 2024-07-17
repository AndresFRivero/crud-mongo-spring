package com.mongo.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Document(collection = "users")
public class UserEntity {
	
	@Id
	private String id;
	
	private String name;
	
	private String lastname;
	
	private int age;
	
	private String gender;
	
	private LocalDateTime dateRegister;

}
