package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongo.entity.UserEntity;


@Repository
public interface IUserRepository extends MongoRepository<UserEntity, String>{

}
