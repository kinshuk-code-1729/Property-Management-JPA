package com.kbcompany.PropertyManagement.Repository;

import com.kbcompany.PropertyManagement.Entity.AddressEntity;
import com.kbcompany.PropertyManagement.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity,Long> {

}
