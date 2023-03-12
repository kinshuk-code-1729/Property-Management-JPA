package com.kbcompany.PropertyManagement.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {
    private Long Id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private double price;
    private String address;
}
