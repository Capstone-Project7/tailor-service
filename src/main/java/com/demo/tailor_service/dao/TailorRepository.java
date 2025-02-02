package com.demo.tailor_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.tailor_service.dao.entity.Tailor;

import java.util.List;
import java.util.Optional;

public interface TailorRepository extends JpaRepository<Tailor, Long> {

    // Custom query to find all active tailors
    List<Tailor> findAllByIsActiveTrue();  // Returns only active tailors

    Optional<Tailor> findByTailorMobileNumber(String tailorMobileNumber);

    // Corrected query to sort tailors by workload in ascending order
    @Query("SELECT t FROM Tailor t ORDER BY t.workload ASC")
    List<Tailor> findAllTailorsSortedByWorkloadAsc();

    Optional<Tailor> findByUsername(String username);
}