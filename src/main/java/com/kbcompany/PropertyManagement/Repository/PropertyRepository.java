package com.kbcompany.PropertyManagement.Repository;

import com.kbcompany.PropertyManagement.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
}
