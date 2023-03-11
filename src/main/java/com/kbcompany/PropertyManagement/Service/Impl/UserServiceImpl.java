package com.kbcompany.PropertyManagement.Service.Impl;

import com.kbcompany.PropertyManagement.Converter.UserConverter;
import com.kbcompany.PropertyManagement.Entity.UserEntity;
import com.kbcompany.PropertyManagement.Model.UserDTO;
import com.kbcompany.PropertyManagement.Repository.UserRepository;
import com.kbcompany.PropertyManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.conv_DTO_to_Entity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.conv_Entity_to_DTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String pwd) {
        return null;
    }
}
