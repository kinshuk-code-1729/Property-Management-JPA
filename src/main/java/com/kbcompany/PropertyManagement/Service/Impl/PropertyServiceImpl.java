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
    private String dbUrl;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = propertyConverter.conv_DTO_to_Entity(propertyDTO);
        pe = propertyRepository.save(pe);
        propertyDTO = propertyConverter.conv_Entity_to_DTO(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        System.out.println("Inside service "+dummy);
        List<PropertyEntity> listofproperties = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyList = new ArrayList<>();
        for(PropertyEntity pe : listofproperties){
            PropertyDTO dto = propertyConverter.conv_Entity_to_DTO(pe);
            propertyList.add(dto);
        }
        return propertyList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> OptionEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(OptionEntity.isPresent()){
            PropertyEntity pe = OptionEntity.get(); // Data from DB
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
            dto =propertyConverter.conv_Entity_to_DTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> OptionEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(OptionEntity.isPresent()){
            PropertyEntity pe = OptionEntity.get(); // Data from DB
            pe.setDescription(propertyDTO.getDescription());
            dto =propertyConverter.conv_Entity_to_DTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> OptionEntity = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(OptionEntity.isPresent()){
            PropertyEntity pe = OptionEntity.get(); // Data from DB
            pe.setPrice(propertyDTO.getPrice());
            dto =propertyConverter.conv_Entity_to_DTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
