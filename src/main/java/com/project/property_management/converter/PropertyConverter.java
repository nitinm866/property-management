package com.project.property_management.converter;

import com.project.property_management.dto.PropertyDTO;
import com.project.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOToPropertyEntity(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());

        return propertyEntity;
    }

    public PropertyDTO convertPropertyEntityToDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        return propertyDTO;
    }
}
