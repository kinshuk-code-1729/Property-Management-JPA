package com.kbcompany.PropertyManagement.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Owner_Table")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String ownerName;
    @Column(name = "Email",nullable = false)
    private String ownerEmail;
    private String phone;
    private String passwd;
}
