package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.BrokerDto;
import com.example.addressbookapp.model.BrokerProfile;
import com.example.addressbookapp.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrokerController {

    @Autowired
    public BrokerService brokerService;

    @PostMapping("/create")
    public BrokerProfile  create(@RequestBody BrokerDto brokerDto) {
        return  brokerService.create(brokerDto);
    }











//    @GetMapping("/getall")
//    public ResponseEntity<List<BrokerProfile>> getAllBroker()
//    {
//        List<BrokerProfile> list=brokerService.getAll().getBody();
//
//        if(list.size()<=0)
//        {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//     return ResponseEntity.status(HttpStatus.CREATED).body(list);
//
//    }



    @GetMapping("/getAll")
    public ResponseEntity<List<BrokerProfile>> getAllBroker() {
        try {
            return brokerService.getAll();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/broker/{id}")
    public ResponseEntity<BrokerProfile> getBrokerById(@PathVariable("id") int id) {
        try {
            return brokerService.getBrokerById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/broker/{id}")
    public Object updateBrokerById (@PathVariable int id, @RequestBody BrokerDto brokerDto) {
        try
        {
        return brokerService.updateBrokerById(id, brokerDto);
    }
catch (Exception e)
{
    e.printStackTrace();
}
        return new ResponseEntity <>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/broker/{brokerId}")
    public ResponseEntity<Void> deleteBroker(@PathVariable("brokerId") int brokerId)
    {
        try
        {
            this.brokerService.deleteBroker(brokerId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }




}
