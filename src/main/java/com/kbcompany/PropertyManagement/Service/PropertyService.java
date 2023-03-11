package com.kbcompany.PropertyManagement.Service;
import java.util.List;
import com.kbcompany.PropertyManagement.Model.PropertyDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyID);
    PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, Long propertyID);
    PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, Long propertyID);
    void deleteProperty(Long propertyID);
}
