package com.example.Traini8.controller;

import com.example.Traini8.dto.TrainingCenterRequest;
import com.example.Traini8.entity.TrainingCenter;
import com.example.Traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centers")
public class TrainingCenterController {

    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<TrainingCenter> createTrainingCenter(
            @Valid @RequestBody TrainingCenterRequest trainingCenter) {
        return ResponseEntity.ok(service.saveTrainingCenter(trainingCenter));
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city) {
        List<TrainingCenter> centers;
        if (state != null || city != null) {
            centers = service.getAllTrainingCentersWithStateOrCityFilters(state, city);
        } else {
            centers = service.getAllTrainingCenters();
        }
        return ResponseEntity.ok(centers);
    }

}
