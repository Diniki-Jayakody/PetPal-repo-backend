package com.PetPal.backend.Controller;

import com.PetPal.backend.Entity.Appointment;
import com.PetPal.backend.Entity.Packages;
import com.PetPal.backend.Entity.doctors;
import com.PetPal.backend.Entity.notices;
import com.PetPal.backend.Service.commonMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/petPal")
public class mainController {

    @Autowired
    private commonMethodService commonMethodService;

    @PostMapping("/addPackage")
    private String addPackage(@RequestBody Packages packages){
        return commonMethodService.addPackage(packages);

    }

    @PostMapping("/addDoctor")
    private String addDoctor(@RequestBody doctors doctors){
        return commonMethodService.addDoctor(doctors);

    }

    @PostMapping("/addAppointment")
    private String addAppointment(@RequestBody Appointment appointment){
        return commonMethodService.addAppointment(appointment);

    }

    @PostMapping("/addNotice")
    private String addNotice(@RequestBody notices notice){
        return commonMethodService.addNotice(notice);

    }

    @GetMapping("/getAppointments/{date}")
    private List<Appointment> getAppointment(@PathVariable String date){
        return commonMethodService.getAppointmentsToday(1L,date);
    }

    @GetMapping("/getAppointmentsOwner/{name}")
    private List<Appointment> getAppointments(@PathVariable String name) {
        return commonMethodService.getAppointmentsByOwner(name);
    }
}
