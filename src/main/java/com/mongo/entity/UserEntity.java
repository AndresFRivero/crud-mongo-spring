package com.mongo.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Entidad que hace referencia a una coleccion de usuario")
public class UserEntity {
	
	@Id
	@Schema(description = "Campo identificador de un documento", accessMode = Schema.AccessMode.READ_ONLY)
	private String id;
	
	@Schema(description = "Campo nombre del usuario")
	private String name;
	
	@Schema(description = "Campo apellido del usuario")
	private String lastname;
	
	@Schema(description = "Campo edad del usuario")
	private int age;
	
	@Schema(description = "Campo genero del usuario")
	private String gender;
	
	@Schema(description = "Campo fecha de registro y/o actualizacion del usuario")
	private LocalDateTime dateRegister;

}
