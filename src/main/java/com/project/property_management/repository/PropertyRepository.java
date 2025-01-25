package com.project.property_management.repository;

import com.project.property_management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

//CrudRepository takes 2 input, 1st is on which entity the crud operation will happen
// and 2nd input is the data type of the primary key column mentioned in entity class.
public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
