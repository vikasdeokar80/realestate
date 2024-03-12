package com.example.addressbookapp.service;
import com.example.addressbookapp.dto.ContactDto;
import com.example.addressbookapp.dto.ResponseDto;
import com.example.addressbookapp.model.Contact;
import com.example.addressbookapp.respository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ContactService {
    @Autowired
    ContactRepo contactRepo;

    public Contact create (ContactDto contactDto) {
        Contact contact= new Contact(contactDto);
        return contactRepo.save(contact);

    }

    public ResponseEntity<List<Contact>> getAllContact() {
        List<Contact> contactList = new ArrayList<>();

        contactList.addAll(contactRepo.findAll());
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

    public ResponseEntity<Contact> getContactById(long id) {
        Optional<Contact> contactById = contactRepo.findById((id));
        if (!contactById.isEmpty()) {
            return new ResponseEntity<>(contactById.get(), HttpStatus.OK);
        } else {

            return null;
        }

    }
    public Object updateContactById (long id, ContactDto contactDto) {
        if (contactRepo.existsById(id)) {
            Contact contact = new Contact(contactDto);
            contact.setId(id);
            Contact newContact = contactRepo.save(contact);
            ResponseDto responseDto= new ResponseDto("New contact has been updated successfully :",newContact);
            return new ResponseEntity<>(responseDto,HttpStatus.OK);
        }
        else {
            return "Id does not match";
        }

    }

    public Object getContactByCity(String city) {
        List<Contact> contactList = contactRepo.findContactByCity(city);
        if(!contactList.isEmpty()) {
            ResponseDto responseDto =new ResponseDto("Below details have been found as per selected city",contactList);
            return new ResponseEntity<>(responseDto,HttpStatus.FOUND);

        }
        else {
            return "No c  ontacts found as per city";
        }


    }

}