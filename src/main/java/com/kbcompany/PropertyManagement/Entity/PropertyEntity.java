package com.kbcompany.PropertyManagement.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Property_Table")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Property_Title",nullable = false)
    private String title;
    private String description;
    private double price;
    private String address;
    @ManyToOne(fetch = FetchType.LAZY) // user data will not be fetched while property is fetched
    @JoinColumn(name = "User_Id",nullable = false)
    private UserEntity userEntity;
}
