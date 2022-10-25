package com.PetPal.backend.Service;


import com.PetPal.backend.Entity.*;

import java.util.List;

public interface commonMethodService {

    String addPackage(Packages packages);

    List<Packages> getPackages();

    String addAppointment(Appointment appointment);

    String addDoctor(doctors doctor);

    String addNotice(notices notice);

    List<Appointment> getAppointmentsToday(Long id , String date);

    List<Appointment> getAppointmentsByOwner(String name);

    String addDiscussion(discussion discussion);

    String addReply(discussionReply discussionReply);

    List<discussionResBody> getAllDiscussions();

}
