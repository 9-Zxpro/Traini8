package com.example.Traini8.service;

import com.example.Traini8.dto.TrainingCenterRequest;
import com.example.Traini8.entity.Address;
import com.example.Traini8.entity.TrainingCenter;
import com.example.Traini8.repository.TrainingCenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {

    private final TrainingCenterRepository repository;

    public TrainingCenterService(TrainingCenterRepository repository) {
        this.repository = repository;
    }


    public TrainingCenter saveTrainingCenter(TrainingCenterRequest trainingCenter) {
        TrainingCenter center = mapToEntity(trainingCenter);
        return repository.save(center);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }

    public List<TrainingCenter> getAllTrainingCentersWithStateOrCityFilters(String state, String city) {
        return repository.findByAddressStateOrAddressCity(state, city);
    }

    private TrainingCenter mapToEntity(TrainingCenterRequest request) {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName(request.getCenterName());
        trainingCenter.setCenterCode(request.getCenterCode());

        // Map address
        Address address = new Address();
        address.setDetailedAddress(request.getAddress().getDetailedAddress());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setPincode(request.getAddress().getPincode());
        trainingCenter.setAddress(address);

        trainingCenter.setStudentCapacity(request.getStudentCapacity());
        trainingCenter.setCoursesOffered(request.getCoursesOffered());
        trainingCenter.setContactEmail(request.getContactEmail());
        trainingCenter.setContactPhone(request.getContactPhone());

        return trainingCenter;
    }
}
