package com.example.addressbookapp.respository;

import com.example.addressbookapp.model.BrokerProfile;
import com.example.addressbookapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerRepo extends JpaRepository<BrokerProfile, Integer> {
}
