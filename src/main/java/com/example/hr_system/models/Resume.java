package com.example.hr_system.models;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resume_seq")
    @SequenceGenerator(name = "resume_seq", sequenceName = "resume_seq", allocationSize = 1)
    private Long id;

    private byte[] resumePDF;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST})
    private JobSeeker jobSeeker;



}
