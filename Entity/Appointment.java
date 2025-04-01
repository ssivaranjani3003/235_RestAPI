package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

    public static List<Appointment> findAll(Sort ascending) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user; 
    private String repairShop; 
    private LocalDateTime appointmentDate;
    private String serviceRequested;
    private String status;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRepairShop() {
        return repairShop;
    }

    public void setRepairShop(String repairShop) {
        this.repairShop = repairShop;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getServiceRequested() {
        return serviceRequested;
    }

    public void setServiceRequested(String serviceRequested) {
        this.serviceRequested = serviceRequested;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
