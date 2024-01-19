package com.example.hr_system.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Employer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    private String email;
    private String password;

    private byte[] image;

    private Role role;

    private String address;

    private String phoneNumber;

    private String city;

    private String aboutCompany;

    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employer")
    private List<Vacancy> vacancyList;





}
