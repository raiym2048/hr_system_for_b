package com.example.hr_system.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "job_seeker_table")
@Data
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "jobSeeker")
    private User user;

    private String country;
    private String address;
    private String phoneNumber;
    private String about;

    @ElementCollection
    private List<String> education;

    @ElementCollection
    private List<Integer> graduationDate;

    private boolean untilNow;
    private String skills;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobSeeker")
    private List<Resume> resumeList;



}
