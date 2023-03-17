package com.kbcompany.PropertyManagement.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Address_Table")
@Getter
@Setter
@NoArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String houseNo;
    private String street;
    private String city;
    private String postalCode;
    private String country;
    @OneToOne
    @JoinColumn(name = "User_Id",nullable = false)
    private UserEntity userEntity;
}
