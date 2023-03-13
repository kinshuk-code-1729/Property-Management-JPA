package com.kbcompany.PropertyManagement.Converter;

import com.kbcompany.PropertyManagement.Entity.UserEntity;
import com.kbcompany.PropertyManagement.Model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity conv_DTO_to_Entity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPasswd(userDTO.getPasswd());
        userEntity.setPhone(userDTO.getPhone());
        return userEntity;
    }
    public UserDTO conv_Entity_to_DTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhone(userEntity.getPhone());
        return userDTO;
    }
}
