package com.project.property_management.service;

import com.project.property_management.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
    public PropertyDTO getProperty(int id);
    public void deleteProperty(Long id);
    public List<PropertyDTO> getAllProperties();
}
