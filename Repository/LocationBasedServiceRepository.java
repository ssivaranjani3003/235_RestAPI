package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.LocationBasedService;

@Repository
public interface LocationBasedServiceRepository extends JpaRepository<LocationBasedService, Long> {
    
}
