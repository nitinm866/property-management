package com.project.property_management.converter;

import com.project.property_management.dto.UserDTO;
import com.project.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        return userEntity;
    }

    public UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setId(userEntity.getId());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        return userDTO;
    }
}
