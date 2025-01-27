package com.project.property_management.service;

import com.project.property_management.dto.UserDTO;

public interface UserService {

    public UserDTO registerUser(UserDTO userDTO);
    public UserDTO loginUser(String email, String password);
}
