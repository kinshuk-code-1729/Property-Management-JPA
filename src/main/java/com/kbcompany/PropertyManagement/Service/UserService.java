package com.kbcompany.PropertyManagement.Service;

import com.kbcompany.PropertyManagement.Model.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email,String password);
}
