package com.PetPal.backend.Repository;

import com.PetPal.backend.Entity.Packages;
import com.PetPal.backend.Entity.notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface noticeRepository extends JpaRepository<notices, Long> {
}
