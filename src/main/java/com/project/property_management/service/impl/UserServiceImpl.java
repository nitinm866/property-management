package com.project.property_management.service.impl;

import com.project.property_management.converter.UserConverter;
import com.project.property_management.dto.UserDTO;
import com.project.property_management.entity.UserEntity;
import com.project.property_management.exception.BusinessException;
import com.project.property_management.exception.ErrorModel;
import com.project.property_management.repository.UserRepository;
import com.project.property_management.service.UserService;
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
    public UserDTO registerUser(UserDTO userDTO) {
        Optional<UserEntity> optUserExists = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if (!optUserExists.isPresent()) {
            UserEntity userEntity = userRepository.save(userConverter.convertUserDTOToUserEntity(userDTO));
            return userConverter.convertUserEntityToUserDTO(userEntity);
        }else{
            List<ErrorModel> errorList = new ArrayList<>();

            ErrorModel error = new ErrorModel();
            error.setErrorMessage("Email address already in use");
            error.setErrorCode("EMAIL_ALREADY_IN_USE");
            errorList.add(error);

            throw new BusinessException(errorList);
        }

    }

    @Override
    public UserDTO loginUser(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntity.isPresent()){
            userDTO = userConverter.convertUserEntityToUserDTO(optionalUserEntity.get());
        }else{
            List<ErrorModel> errorList = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setErrorCode("INVALID_CREDENTIALS");
            error.setErrorMessage("Invalid username or password");
            errorList.add(error);

            throw new BusinessException(errorList);
        }
        return userDTO;
    }
}
