package com.sajal.addressbookapp.respository;

import com.sajal.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {

    @Query(value = "SELECT * from contact c where c.city= :cityName", nativeQuery = true)
        List<Contact> findContactByCity(@Param("cityName") String city);
    }


