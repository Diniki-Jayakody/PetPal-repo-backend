package com.PetPal.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class notices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String noticeTopic;
    private String publisherName;
    private String NIC;
    private String publisherAddress;
    private String telNum;
    private String email;
    private String requestDate;
    private String district;
    private String noticeType;
    private String url;


    public notices() {
    }
}
