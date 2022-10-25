package com.PetPal.backend.Repository;

import com.PetPal.backend.Entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface packageRepository extends JpaRepository<Packages , Long> {
}
