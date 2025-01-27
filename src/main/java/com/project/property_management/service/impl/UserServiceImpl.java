package com.project.property_management.service.impl;

import com.project.property_management.converter.UserConverter;
import com.project.property_management.dto.UserDTO;
import com.project.property_management.entity.UserEntity;
import com.project.property_management.repository.UserRepository;
import com.project.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        UserEntity userEntity = userRepository.save(userConverter.convertUserDTOToUserEntity(userDTO));
        return userConverter.convertUserEntityToUserDTO(userEntity);
    }

    @Override
    public UserDTO loginUser(String email, String password) {
        return null;
    }
}
