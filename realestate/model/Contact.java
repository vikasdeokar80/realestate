package com.sajal.addressbookapp.model;

import com.sajal.addressbookapp.dto.ContactDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long mobileNo;

    private String emailId;
    private String city;

    public Contact(long id, String name, long mobileNo, String emailId, String city) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.city = city;

    }

    public Contact() {
    }

    public Contact(ContactDto contactDto) {
        this.name = contactDto.name;
        this.mobileNo = contactDto.mobileNo;
        this.emailId = contactDto.emailId;
        this.city = contactDto.city;
    }

    public Contact(long id, ContactDto contactDto) {
        this.id=id;
        this.name = contactDto.name;
        this.mobileNo = contactDto.mobileNo;
        this.emailId = contactDto.emailId;
        this.city = contactDto.city;
    }
}
