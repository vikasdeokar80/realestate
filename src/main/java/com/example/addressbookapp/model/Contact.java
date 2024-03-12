package com.example.addressbookapp.model;
import com.example.addressbookapp.dto.ContactDto;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String name;

    public long mobileNo;

    public String emailId;
    public String city;

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
