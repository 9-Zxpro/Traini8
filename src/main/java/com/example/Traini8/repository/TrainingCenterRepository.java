package com.example.Traini8.repository;

import com.example.Traini8.entity.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    List<TrainingCenter>  findByAddressStateOrAddressCity(String state, String city);
}
