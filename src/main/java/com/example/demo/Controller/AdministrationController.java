package com.example.demo.Controller;


import com.example.demo.Service.UserDetailsServiceImpl;
import com.example.demo.dto.MessagesQRequsts.InventoryMQRequest;
import com.example.demo.dto.request.EstatesRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.RabbitMQ.MessageConfig.*;

@RestController
@RequestMapping("/admin")
public class AdministrationController {


    @Autowired
    RabbitTemplate template;

    @PostMapping(value = "/InventoryRequest")
    @PreAuthorize("hasAuthority('estates_write')")
    public ResponseEntity<Object> addEstates(@RequestBody InventoryMQRequest inventoryMQRequest) throws Exception {
        try {

            template.convertAndSend(EXCHANGE,ROUTING_KEY,inventoryMQRequest);



        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>("massage :\"Error Bad Request\"", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("massage :\"Estates Add Successfully\"", HttpStatus.OK);

    }

}
