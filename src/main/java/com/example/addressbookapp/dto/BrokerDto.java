package com.example.addressbookapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrokerDto {
    private int id;
    private String firstName;
    private String lastName;
    private long mobileNumber;
    private String propertyType;

    public BrokerDto(int id, String firstName, String lastName, long mobileNumber, String propertyType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.propertyType = propertyType;
    }
}
