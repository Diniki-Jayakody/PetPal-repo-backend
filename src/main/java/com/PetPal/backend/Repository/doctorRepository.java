package com.PetPal.backend.Repository;

import com.PetPal.backend.Entity.doctors;
import com.PetPal.backend.Entity.notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface doctorRepository extends JpaRepository<doctors, Long> {
}
