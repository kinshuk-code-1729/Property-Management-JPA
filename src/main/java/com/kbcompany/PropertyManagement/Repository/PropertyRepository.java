package com.kbcompany.PropertyManagement.Repository;

import com.kbcompany.PropertyManagement.Entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
//    @Query("SELECT p FROM PropertyEntity p WHERE p.userEntity.id = :userId and p.title = :title")
//    List<PropertyEntity> finAllbyUserEntityId(@Param("userId") Long userId,@Param("title") Long title);
    List<PropertyEntity> findAllByUserEntityId(@Param("userId") Long userId);
}
