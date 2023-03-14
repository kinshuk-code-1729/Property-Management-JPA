package com.kbcompany.PropertyManagement.Service.Impl;

import com.kbcompany.PropertyManagement.Converter.UserConverter;
import com.kbcompany.PropertyManagement.Entity.UserEntity;
import com.kbcompany.PropertyManagement.Exception.BuisnessException;
import com.kbcompany.PropertyManagement.Exception.ErrorModel;
import com.kbcompany.PropertyManagement.Model.UserDTO;
import com.kbcompany.PropertyManagement.Repository.UserRepository;
import com.kbcompany.PropertyManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if (optionalUserEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Email_Already_Exists");
            errorModel.setMessage("User email you are trying to register already exists");
            errorModelList.add(errorModel);

            throw new BuisnessException(errorModelList);
        }
        UserEntity userEntity = userConverter.conv_DTO_to_Entity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.conv_Entity_to_DTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntity.isPresent()){
            userDTO = userConverter.conv_Entity_to_DTO(optionalUserEntity.get());
        }
        else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid_Login");
            errorModel.setMessage("Incorrect User Login Credentials !!!!");
            errorModelList.add(errorModel);

            throw new BuisnessException(errorModelList);
        }
        return userDTO;
    }
}
