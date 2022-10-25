package com.PetPal.backend.Service;





import com.PetPal.backend.Entity.*;
import com.PetPal.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class commonMethodServiceImpl implements commonMethodService {

    @Autowired
    private packageRepository packageRepository;

    @Autowired
    private appointmentRepository appointmentRepository;

    @Autowired
    private doctorRepository doctorRepository;

    @Autowired
    private noticeRepository noticeRepository;

    @Autowired
    private doctorAppointmentRepository doctorApRepo;

    @Autowired
    private discussionRepository discussionRepository;

    @Autowired
    private discussionReplyRepository discussionReplyRepository;

    @Override
    public String addPackage(Packages packages) {
        packageRepository.save(packages);
        return "Added";
    }

    @Override
    public List<Packages> getPackages() {
        return packageRepository.findAll();
    }

    @Override
    public String addAppointment(Appointment appointment) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        appointment.setDate(formatter.format(date));
        Optional<doctorsAppoinments> doctorsAppoinments = doctorApRepo.findByDocIdAndDate(appointment.getDoctorId(),appointment.getDate());
        Optional<doctors> doctor = doctorRepository.findById(appointment.getDoctorId());
        if(doctorsAppoinments.isPresent()){
            if(doctorsAppoinments.get().getAmount()>doctorsAppoinments.get().getAppointments()){
                appointmentRepository.save(appointment);
                doctorsAppoinments.get().setAppointments(doctorsAppoinments.get().getAppointments()+1);
                doctorApRepo.save(doctorsAppoinments.get());
                return "success";
            }
            else return "No Space";
        }

        if(doctor.isPresent()){
            com.PetPal.backend.Entity.doctorsAppoinments doctorsAppoinments1 = new doctorsAppoinments();
            doctorsAppoinments1.setDocId(appointment.getDoctorId());
            doctorsAppoinments1.setDate(appointment.getDate());
            doctorsAppoinments1.setAmount(doctor.get().getAmount());
            doctorsAppoinments1.setAppointments(1);
            doctorApRepo.save(doctorsAppoinments1);
            appointmentRepository.save(appointment);
            return "success";
        }
        return "error doctor";
    }

    @Override
    public String addDoctor(doctors doctor) {
        doctorRepository.save(doctor);
        return "success";
    }

    @Override
    public String addNotice(notices notice) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        System.out.println(formatter.format(date));
        notice.setRequestDate(formatter.format(date));
        noticeRepository.save(notice);
        return "success";
    }

    @Override
    public List<Appointment> getAppointmentsToday(Long id, String date) {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<Appointment> appointments1 = new ArrayList<>();
        for(Appointment appointment : appointments){
            if(appointment.getDate().equals(date) && appointment.getDoctor().equals(id)){
                appointments1.add(appointment);
            }
        }
        return appointments1;
    }

    @Override
    public List<Appointment> getAppointmentsByOwner(String name) {
        return appointmentRepository.findByOwnerName(name);
    }

    @Override
    public String addDiscussion(discussion discussion) {
        discussionRepository.save(discussion);
        return "success";
    }

    @Override
    public String addReply(discussionReply discussionReply) {
        discussionReplyRepository.save(discussionReply);
        return "success";
    }

    @Override
    public List<discussionResBody> getAllDiscussions() {
        List<discussion> discussions = discussionRepository.findAll();
        List<discussionReply> discussionReplies = discussionReplyRepository.findAll();
        List<discussionResBody> discussionResBodies = new ArrayList<>();
        for(discussion discussion : discussions){
            discussionResBody discussionResBody = new discussionResBody();
            discussionResBody.setDiscussion(discussion);
            List<discussionReply> discussionReplies1 = new ArrayList<>();
            for(discussionReply discussionReply : discussionReplies){
                if(discussionReply.getD_id().equals(discussion.getId())){
                    discussionReplies1.add(discussionReply);

                }
            }
            discussionResBody.setDiscussionReplies(discussionReplies1);
            discussionResBodies.add(discussionResBody);
        }
        return discussionResBodies;
    }
}
