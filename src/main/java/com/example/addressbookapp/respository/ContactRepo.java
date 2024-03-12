package com.example.addressbookapp.respository;

import com.example.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    List<Contact> findContactByCity(String city);
}
