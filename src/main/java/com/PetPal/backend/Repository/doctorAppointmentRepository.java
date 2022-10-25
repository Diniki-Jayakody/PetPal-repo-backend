package com.PetPal.backend.Repository;

import com.PetPal.backend.Entity.doctors;
import com.PetPal.backend.Entity.doctorsAppoinments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface doctorAppointmentRepository extends JpaRepository<doctorsAppoinments, Long> {

    Optional<doctorsAppoinments> findByDocIdAndDate(Long id,String date);
}
