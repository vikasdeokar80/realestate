package com.sajal.addressbookapp.service;

import com.sajal.addressbookapp.dto.ContactDto;
import com.sajal.addressbookapp.dto.ResponseDto;
import com.sajal.addressbookapp.model.Contact;
import com.sajal.addressbookapp.respository.ContactRepo;
import com.sajal.addressbookapp.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IService{
    @Autowired
    ContactRepo contactRepo;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    EmailSenderService emailSenderService;

    public Contact create (ContactDto contactDto) {
        Contact contact= new Contact(contactDto);
        return contactRepo.save(contact);

    }

    public ResponseEntity<List<Contact>> getAllContact() {
        List<Contact> contactList = new ArrayList<>();

        contactList.addAll(contactRepo.findAll());
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

    public ResponseEntity<Contact> getContactById(int id) {
        Optional<Contact> contactById = contactRepo.findById(id);
        if (!contactById.isEmpty()) {
            return new ResponseEntity<>(contactById.get(), HttpStatus.OK);
        } else {

            return null;
        }

    }
    public Object updateContactById (int id, ContactDto contactDto) {
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
            return "No contacts found as per city";
        }


   }
    public Object contactDeleteById(int id) {
    contactRepo.deleteById(id);
        return "ID: "+id+ " has been deleted successfully";

   }
@Override
public Contact postContact(ContactDto contactDto) {
        Contact user=  new Contact(contactDto);
        contactRepo.save(user);
        String token= tokenUtil.createToken(user.getId());
    System.out.println(token);
    emailSenderService.sendEmail(user.getEmailId(), "Test email for Addressbook","Hello Sajal" +", Token : "+"http://localhost:8030/api/getContactByToken/"+token);
    return user;

}

    @Override
    public Contact getContactByToken(String token) {
        int userId= tokenUtil.decodeToken(token);

        return contactRepo.findById(userId).get();
    }

    @Override
    public String deleteContactByTokenAndId(String token, int id) {
     contactDeleteById(id);


        return "Deleted";
    }

}
