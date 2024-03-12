package com.example.addressbookapp.dto;

public class ContactDto
{
    public String name;

    public ContactDto(String name, long mobileNo, String emailId, String city) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.city = city;
    }

    public long mobileNo;

    public String emailId;
    public String city;

}
