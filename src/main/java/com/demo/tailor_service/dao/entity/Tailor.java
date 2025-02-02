package com.demo.tailor_service.dao.entity;

//package com.example.tailormanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="tailor_details")
public class Tailor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tailor_id")
    private Long tailorId;

    @Column(name = "tailor_name", nullable = false)
    private String tailorName;

    @Column(name="tailor_mobile_number", nullable = false)
    private String tailorMobileNumber;

    @Column(name = "workloads")
    private Long workload;

    @Column(name = "is_active")
    private Boolean isActive = true;  // Default value is true (active)
}

