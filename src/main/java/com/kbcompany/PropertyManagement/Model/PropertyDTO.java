package com.kbcompany.PropertyManagement.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String address;
    private Long userId;
}
