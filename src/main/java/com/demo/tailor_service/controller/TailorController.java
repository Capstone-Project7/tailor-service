package com.demo.tailor_service.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.tailor_service.dao.entity.Tailor;
import com.demo.tailor_service.service.TailorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tailors")
public class TailorController {

    @Autowired
    private TailorService service;

    // Add a new tailor
    @PostMapping
    public ResponseEntity<Tailor> addTailor(@RequestBody Tailor tailor) {
        Tailor createdTailor = service.addTailor(tailor);
        return ResponseEntity.status(201).body(createdTailor);  // Returning status 201 (Created)
    }

    // Get all active tailors
    @GetMapping
    public ResponseEntity<List<Tailor>> getAllTailors() {
        List<Tailor> tailors = service.getAllTailors();
        return ResponseEntity.ok(tailors);  // Returning status 200 (OK)
    }

    // Get tailor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Tailor> getTailorById(@PathVariable Long id) {
        Optional<Tailor> tailor = service.getTailorById(id);
        if (tailor.isPresent()) {
            return ResponseEntity.ok(tailor.get());  // Returning status 200 (OK)
        } else {
            return ResponseEntity.status(404).body(null);  // Returning status 404 (Not Found)
        }
    }

    @GetMapping("/number/{num}")
    public ResponseEntity<Tailor> getTailorByMobileNumber(@PathVariable String num) {
        Optional<Tailor> tailor = service.getTailorByMobileNumber(num);
        if (tailor.isPresent()) {
            return ResponseEntity.ok(tailor.get());  // Returning status 200 (OK)
        } else {
            return ResponseEntity.status(404).body(null);  // Returning status 404 (Not Found)
        }
    }
    

    // Update tailor workload
    @PutMapping("")
    public ResponseEntity<Tailor> updateTailorWorkload(@RequestParam Long id, @RequestParam Long workload) {
        Tailor updatedTailor = service.updateTailorWorkload(id, workload);
        return ResponseEntity.ok(updatedTailor);  // Returning status 200 (OK)
    }

    // Soft delete (deactivate) a tailor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTailor(@PathVariable Long id) {
        service.deactivateTailor(id);  // Perform soft delete (deactivate)
        return ResponseEntity.status(204).build();  // Returning status 204 (No Content)
    }

    @GetMapping("/workload")
    public ResponseEntity<List<Tailor>> sortTailorsByWorkload() {
        return new ResponseEntity<List<Tailor>>(service.sortTailorsByWorkload(),HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Tailor> getTailorByUsername(@PathVariable String username) {
        Optional<Tailor> tailor = service.getTailorByUsername(username);
        if (tailor.isPresent()) {
            return ResponseEntity.ok(tailor.get());  // Returning status 200 (OK)
        } else {
            return ResponseEntity.status(404).body(null);  // Returning status 404 (Not Found)
        }
    }
}
