package com.project.property_management.repository;

import com.project.property_management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//CrudRepository takes 2 input, 1st is on which entity the crud operation will happen
// and 2nd input is the data type of the primary key column mentioned in entity class.
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    //@Query("SELECT user from USER_TABLE user where ownerEmail = ?1 AND password=?2")
    //we can write findByOwnerEmailOrPassword,findByOwnerEmailOrPhoneNumber,
    //And, Or,Between we can use to form the method name, to which spring JPA internally interpret
    // and using the entity variable name along with the conditions and give us back the result.
    Optional<UserEntity> findByOwnerEmailAndPassword(String ownerEmail,String password);
    Optional<UserEntity> findByOwnerEmail(String ownerEmail);
}
