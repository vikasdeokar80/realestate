package com.example.addressbookapp.controller;
import com.example.addressbookapp.dto.ContactDto;
import com.example.addressbookapp.model.Contact;
import com.example.addressbookapp.respository.ContactRepo;
import com.example.addressbookapp.service.ContactService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactController
{
    @Autowired
    ContactService contactService;
    @PostMapping("/mycontacts")
    public Contact createNewContact(@RequestBody ContactDto contactDto) {
        return  contactService.create(contactDto);
    }

    @GetMapping("/mycontacts")
    public ResponseEntity<List<Contact>> getAllContact() {
        return contactService.getAllContact();

    }

    @GetMapping("/mycontacts/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") long id) {
        return contactService.getContactById(id);
    }

    @PutMapping("/mycontacts/{id}")
    public Object updateContactById (@PathVariable long id, @RequestBody ContactDto contactDto) {
        return contactService.updateContactById(id, contactDto);
    }

    @GetMapping("/mycontacts/city")
    public Object getContactByCity (@RequestParam String city){
        return contactService.getContactByCity(city);
    }


}
