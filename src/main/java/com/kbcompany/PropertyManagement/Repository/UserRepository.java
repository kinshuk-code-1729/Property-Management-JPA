package com.kbcompany.PropertyManagement.Repository;

import com.kbcompany.PropertyManagement.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
