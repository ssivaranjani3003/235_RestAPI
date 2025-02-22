package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Appointment;
import com.example.demo.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Create or Update Appointment
    @PostMapping
    public Appointment saveAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    // Get All Appointments with Pagination
    @GetMapping
    public Page<Appointment> getAllAppointments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return appointmentService.getAllAppointments(pageable);
    }

    // Get Appointment by ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    // Update Appointment by ID
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        Appointment appointment = appointmentService.updateAppointment(id, updatedAppointment);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Appointment by ID
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Appointment with ID " + id + " has been deleted.";
    }

    // Get Appointments by Status with Pagination
    @GetMapping("/page")
    public Page<Appointment> getByAppointments(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="5") int size)
    {
        return appointmentService.getAppointmentBystatus(page, size);
    }
    @GetMapping("/sorting")
    public List<Appointment> sortbyappointments()
    {
        return appointmentService.SortByAppointments();
    }
}
