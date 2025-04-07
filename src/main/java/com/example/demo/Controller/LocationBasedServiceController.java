package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.LocationBasedService;
import com.example.demo.service.LocationBasedServiceService;

@RestController
@RequestMapping("/locations")
public class LocationBasedServiceController {

    @Autowired
    private LocationBasedServiceService service;

    // Get all locations
    @GetMapping
    public ResponseEntity<List<LocationBasedService>> getAllLocations() {
        return ResponseEntity.ok(service.getAllLocations());
    }

    // Get location by ID
    @GetMapping("/{id}")
    public ResponseEntity<LocationBasedService> getLocationById(@PathVariable Long id) {
        LocationBasedService location = service.getLocationById(id);
        if (location != null) {
            return ResponseEntity.ok(location);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add or update a location
    @PostMapping
    public ResponseEntity<LocationBasedService> saveOrUpdateLocation(@RequestBody LocationBasedService location) {
        return ResponseEntity.ok(service.saveOrUpdateLocation(location));
    }

    // Update a location by ID
    @PutMapping("/{id}")
    public ResponseEntity<LocationBasedService> updateLocation(@PathVariable Long id, @RequestBody LocationBasedService updatedLocation) {
        LocationBasedService location = service.updateLocation(id, updatedLocation);
        if (location != null) {
            return ResponseEntity.ok(location);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a location
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        service.deleteLocation(id);
        return ResponseEntity.ok("Location deleted successfully!");
    }
}
