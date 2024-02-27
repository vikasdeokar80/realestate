package com.sajal.addressbookapp.service;

import com.sajal.addressbookapp.dto.ContactDto;
import com.sajal.addressbookapp.model.Contact;

public interface IService {

        Contact postContact(ContactDto contactDto);

    Contact getContactByToken(String token);

    String deleteContactByTokenAndId(String token, int id);
}
