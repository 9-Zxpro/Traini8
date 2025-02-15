package com.example.Traini8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Training_center")
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String centerName;

    @Column(nullable = false, length = 12)
    private String centerCode;

    @Embedded
    private Address address;

    @Column(nullable = false)
    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(updatable = false)
    private Long createdOn;

    private String contactEmail;

    @Column(nullable = false)
    private String contactPhone;

    @PrePersist
    protected void onCreate() {
        this.createdOn = System.currentTimeMillis();
    }
}