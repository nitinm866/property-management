package com.project.property_management.service.impl;

import com.project.property_management.converter.PropertyConverter;
import com.project.property_management.dto.PropertyDTO;
import com.project.property_management.entity.PropertyEntity;
import com.project.property_management.repository.PropertyRepository;
import com.project.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

// If we mention @Service, @Configuration, @Component, @Repository in the class,
// then spring makes the class as Singleton instance and returns the same object when it is called in the application.
// This makes it memory efficient. As it is a Service class, it is better to mention it as @Service,
// although all other annotations mentioned above also does the same thing.
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyConverter.convertDTOToPropertyEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);

        PropertyDTO propDTO = propertyConverter.convertPropertyEntityToDTO(propertyEntity);

        return propDTO;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        //Optional is a Wrapper class introduced in Java 8
        Optional<PropertyEntity> propertyEntityOptional = propertyRepository.findById(propertyId);
        PropertyDTO propDTO = null;
        if(propertyEntityOptional.isPresent()){
            PropertyEntity pe = propertyEntityOptional.get();
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());
            pe.setTitle(propertyDTO.getTitle());

            pe = propertyRepository.save(pe);
            propDTO = propertyConverter.convertPropertyEntityToDTO(pe);
        }
        return propDTO;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> OptPE = propertyRepository.findById(propertyId);
        PropertyEntity pe = null;
        /*OptPE.ifPresent(propertyEntity -> {
            propertyEntity.setDescription(propertyDTO.getDescription());
        });*/
        if(OptPE.isPresent()){
            pe = OptPE.get();
            pe.setDescription(propertyDTO.getDescription());
            pe = propertyRepository.save(pe);
        }

        return propertyConverter.convertPropertyEntityToDTO(pe);
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> OptPe = propertyRepository.findById(propertyId);
        PropertyEntity pe = null;
        if(OptPe.isPresent()){
            pe = OptPe.get();
            pe.setPrice(propertyDTO.getPrice());
            pe = propertyRepository.save(pe);
        }
        return propertyConverter.convertPropertyEntityToDTO(pe);
    }

    @Override
    public PropertyDTO getProperty(int id) {
        return null;
    }

    @Override
    public void deleteProperty(Long id) {
        Optional<PropertyEntity> OptPE = propertyRepository.findById(id);

        if(OptPE.isPresent()){
            propertyRepository.deleteById(id);
        }

    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyEntity = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for (PropertyEntity pe : propertyEntity) {
            //PropertyDTO propertyDTO = propertyConverter.convertPropertyEntityToDTO(pe);
            propertyDTOList.add(propertyConverter.convertPropertyEntityToDTO(pe));
        }
        return propertyDTOList;
    }
}
