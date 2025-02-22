package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.LocationBasedService;
import com.example.demo.Repository.LocationBasedServiceRepository;

@Service
public class LocationBasedServiceService {

    @Autowired
    private LocationBasedServiceRepository repository;

    // Get all locations
    public List<LocationBasedService> getAllLocations() {
        return repository.findAll();
    }

    // Get location by ID
    public LocationBasedService getLocationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Add or update a location
    public LocationBasedService saveOrUpdateLocation(LocationBasedService location) {
        return repository.save(location);
    }

    // Update a location by ID
    public LocationBasedService updateLocation(Long id, LocationBasedService updatedLocation) {
        // Check if the location exists
        LocationBasedService existingLocation = repository.findById(id).orElse(null);
        if (existingLocation != null) {
            // Update the existing location with the new details
            
            existingLocation.setLatitude(updatedLocation.getLatitude());
            existingLocation.setLongitude(updatedLocation.getLongitude());
            // Save and return the updated location
            return repository.save(existingLocation);
        }
        // Return null if the location is not found
        return null;
    }

    // Delete a location
    public void deleteLocation(Long id) {
        repository.deleteById(id);
    }
}
