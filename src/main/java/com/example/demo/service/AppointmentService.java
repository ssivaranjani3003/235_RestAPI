package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Appointment;
import com.example.demo.Repository.AppointmentRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    // Create or Update Appointment
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Get All Appointments with Pagination
    public Page<Appointment> getAllAppointments(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    // Get Appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    // Delete Appointment by ID
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    

    // Update Appointment by ID
    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        // Check if the appointment exists
        Appointment existingAppointment = appointmentRepository.findById(id).orElse(null);
        if (existingAppointment != null) {
            // Update the fields of the existing appointment
            existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
            
            existingAppointment.setStatus(updatedAppointment.getStatus());
            // Save and return the updated appointment
            return appointmentRepository.save(existingAppointment);
        } else {
            return null; // Return null if the appointment doesn't exist
        }

        
    }

    public Page<Appointment> getAppointmentBystatus(int page,int size)
{
   Pageable pageable= PageRequest.of(page,size);
   return appointmentRepository.findAll(pageable);
}


    public List<Appointment> SortByAppointments()
    {
    return appointmentRepository.findAll(Sort.by("user").ascending());
}
}
