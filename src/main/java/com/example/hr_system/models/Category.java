package com.example.hr_system.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Vacancy> vacancyList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Position> positionList;
}
