package com.kbcompany.PropertyManagement.Converter;

import com.kbcompany.PropertyManagement.Entity.PropertyEntity;
import com.kbcompany.PropertyManagement.Model.PropertyDTO;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity conv_DTO_to_Entity(PropertyDTO propertyDTO){
        PropertyEntity PE = new PropertyEntity();
        PE.setTitle(propertyDTO.getTitle());
        PE.setAddress(propertyDTO.getAddress());
        PE.setOwnerEmail(propertyDTO.getOwnerEmail());
        PE.setOwnerName(propertyDTO.getOwnerName());
        PE.setPrice(propertyDTO.getPrice());
        PE.setDescription(propertyDTO.getDescription());
        return PE;
    }
    public PropertyDTO conv_Entity_to_DTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setID(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setDescription(propertyEntity.getDescription());
        return propertyDTO;
    }
}
