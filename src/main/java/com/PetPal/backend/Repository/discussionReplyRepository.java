package com.PetPal.backend.Repository;

import com.PetPal.backend.Entity.discussionReply;
import com.PetPal.backend.Entity.doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface discussionReplyRepository extends JpaRepository<discussionReply, Long> {
}
