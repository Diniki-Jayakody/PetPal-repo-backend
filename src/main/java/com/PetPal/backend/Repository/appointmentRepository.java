package com.PetPal.backend.Repository;

import com.PetPal.backend.Entity.Appointment;
import com.PetPal.backend.Entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface appointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByOwnerName(String name);
}
