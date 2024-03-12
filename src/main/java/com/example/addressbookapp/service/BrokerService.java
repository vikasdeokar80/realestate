package com.example.addressbookapp.service;


import com.example.addressbookapp.dto.BrokerDto;
import com.example.addressbookapp.dto.ResponseDto;
import com.example.addressbookapp.model.BrokerProfile;
import com.example.addressbookapp.respository.BrokerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrokerService {

    @Autowired
    private BrokerRepo brokerRepo;

    public BrokerProfile create(BrokerDto brokerDto) {
        BrokerProfile brokerProfile = new BrokerProfile();
        brokerProfile.setId(brokerDto.getId());
        brokerProfile.setFirstName(brokerDto.getFirstName());
        brokerProfile.setLastName(brokerDto.getLastName());
        brokerProfile.setMobileNumber(brokerDto.getMobileNumber());
        brokerProfile.setPropertyType(brokerDto.getPropertyType());
        return brokerRepo.save(brokerProfile);
    }

    public ResponseEntity<List<BrokerProfile>> getAll() {
        List<BrokerProfile> brokerProfileList = new ArrayList<>();
        brokerProfileList.addAll(brokerRepo.findAll());
        return new ResponseEntity<>(brokerProfileList, HttpStatus.OK);
    }

    public ResponseEntity<BrokerProfile> getBrokerById(int id) {
        Optional<BrokerProfile> brokerById = brokerRepo.findById(id);
        return brokerById.map(brokerProfile -> new ResponseEntity<>(brokerProfile, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Object> updateBrokerById(Integer id, BrokerDto brokerDto) {
        if (brokerRepo.existsById(id)) {
            BrokerProfile brokerProfile = new BrokerProfile();
            brokerProfile.setId(id);
            brokerProfile.setFirstName(brokerDto.getFirstName());
            brokerProfile.setLastName(brokerDto.getLastName());
            brokerProfile.setMobileNumber(brokerDto.getMobileNumber());
            brokerProfile.setPropertyType(brokerDto.getPropertyType());
            BrokerProfile newContact = brokerRepo.save(brokerProfile);
            ResponseDto responseDto = new ResponseDto("New contact has been updated successfully :", newContact);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Id does not match", HttpStatus.NOT_FOUND);
        }
    }

    public void deleteBroker(int bid)
    {
        brokerRepo.deleteById(bid);
    }

}

//   //getAllData
//    public ResponseEntity<List<BrokerProfile>> getAll()
//    {
//        List<BrokerProfile> brokerProfileList=new ArrayList<>();
//        brokerProfileList.addAll(brokerRepo.findAll());
//        return new ResponseEntity<>(brokerProfileList , HttpStatus.OK);
//    }
//
//    //get data by id
//
//    public ResponseEntity<BrokerProfile> getBrokerById(int id) {
//        Optional<BrokerProfile> brokerById = brokerRepo.findById(id);
//        if (!brokerById.isEmpty()) {
//            return new ResponseEntity<>(brokerById.get(), HttpStatus.OK);
//        } else {
//            return null;
//        }
//
//        //Update Data By Id
//
//        public Object updateContactById(Integer id ,BrokerDto brokerDto){
//       if (brokerRepo.existsById(id)) {
//           BrokerProfile contact = new BrokerProfile(brokerDto);
//          contact.setId(id);
//          BrokerProfile newContact = brokerRepo.save(contact);
//          ResponseDto responseDto= new ResponseDto("New contact has been updated successfully :",newContact);
//           return new ResponseEntity<>(responseDto,HttpStatus.OK);
//     }
//       else {
//           return "Id does not match";
//        }
//
//        public BrokerDto updateService(BrokerDto, Integer id) {
//
//            return null;
//        }
//
////
////     public void updateBrokerProfile(BrokerProfile brokrProfile,int id)
////      {
////           brokerProfile.setId(id);
////         BrokerRepo.save(brokerProfile);
////      }
////    }
//
//
//    }
//    }




