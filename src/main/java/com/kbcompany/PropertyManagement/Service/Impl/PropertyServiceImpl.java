package com.kbcompany.PropertyManagement.Service.Impl;

import com.kbcompany.PropertyManagement.Converter.PropertyConverter;
import com.kbcompany.PropertyManagement.Entity.PropertyEntity;
import com.kbcompany.PropertyManagement.Model.PropertyDTO;
import com.kbcompany.PropertyManagement.Repository.PropertyRepository;
import com.kbcompany.PropertyManagement.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Value("${pms.dummy:}")
    private String dummy;
    @Value("${spring.datasource.url:}")
    private String DBurl;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity PE = propertyConverter.conv_DTO_to_Entity(propertyDTO);
        PE = propertyRepository.save(PE);
        propertyDTO = propertyConverter.conv_Entity_to_DTO(PE);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        System.out.println("Inside service "+dummy);
        List<PropertyEntity> listofproperties = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyList = new ArrayList<>();
        for(PropertyEntity PE : listofproperties){
            PropertyDTO DTO = propertyConverter.conv_Entity_to_DTO(PE);
            propertyList.add(DTO);
        }
        return propertyList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> OptionEntity = propertyRepository.findById(propertyID);
        PropertyDTO DTO = null;
        if(OptionEntity.isPresent()){
            PropertyEntity PE = OptionEntity.get(); // Data from DB
            PE.setTitle(propertyDTO.getTitle());
            PE.setAddress(propertyDTO.getAddress());
            PE.setPrice(propertyDTO.getPrice());
            PE.setDescription(propertyDTO.getDescription());
            DTO =propertyConverter.conv_Entity_to_DTO(PE);
            propertyRepository.save(PE);
        }
        return DTO;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> OptionEntity = propertyRepository.findById(propertyID);
        PropertyDTO DTO = null;
        if(OptionEntity.isPresent()){
            PropertyEntity PE = OptionEntity.get(); // Data from DB
            PE.setDescription(propertyDTO.getDescription());
            DTO =propertyConverter.conv_Entity_to_DTO(PE);
            propertyRepository.save(PE);
        }
        return DTO;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyID) {
        Optional<PropertyEntity> OptionEntity = propertyRepository.findById(propertyID);
        PropertyDTO DTO = null;
        if(OptionEntity.isPresent()){
            PropertyEntity PE = OptionEntity.get(); // Data from DB
            PE.setPrice(propertyDTO.getPrice());
            DTO =propertyConverter.conv_Entity_to_DTO(PE);
            propertyRepository.save(PE);
        }
        return DTO;
    }

    @Override
    public void deleteProperty(Long propertyID) {
        propertyRepository.deleteById(propertyID);
    }
}
