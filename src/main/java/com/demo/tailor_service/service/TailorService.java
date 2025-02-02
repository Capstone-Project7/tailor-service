package com.demo.tailor_service.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.tailor_service.dao.TailorRepository;
import com.demo.tailor_service.dao.entity.Tailor;

import java.util.List;
import java.util.Optional;

@Service
public class TailorService {

    @Autowired
    private TailorRepository repository;

    // Add a new tailor
    public Tailor addTailor(Tailor tailor) {
        return repository.save(tailor);
    }

    // Get all active tailors
    public List<Tailor> getAllTailors() {
        return repository.findAllByIsActiveTrue();  // Only fetch active tailors
    }

    // Get tailor by ID
    public Optional<Tailor> getTailorById(Long id) {
        return repository.findById(id);
    }

    //Get tailor by mobile number
    public Optional<Tailor> getTailorByMobileNumber(String mobileNumber) {
        return repository.findByTailorMobileNumber(mobileNumber);
    }

    // Update only the workload of a tailor
    public Tailor updateTailorWorkload(Long id, Long workload) {
        Tailor tailor = repository.findById(id).orElseThrow(() -> new RuntimeException("Tailor not found"));
        tailor.setWorkload(tailor.getWorkload() + workload);  // Only updating the workload
        return repository.save(tailor);
    }

    // Soft delete (deactivate) a tailor
    public void deactivateTailor(Long id) {
        Tailor tailor = repository.findById(id).orElseThrow(() -> new RuntimeException("Tailor not found"));
        tailor.setIsActive(false);  // Set the active flag to false
        repository.save(tailor);
    }

    //Sort the tailors according to the workload in ascending order
    public List<Tailor> sortTailorsByWorkload() {
        return repository.findAllTailorsSortedByWorkloadAsc();
    }

}
