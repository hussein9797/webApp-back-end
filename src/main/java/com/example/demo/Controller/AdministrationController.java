package com.example.demo.Controller;


import com.example.demo.RabbitMQ.MessageConfig;
import com.example.demo.dto.MessagesQRequsts.InventoryMQRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.RabbitMQ.MessageConfig.EXCHANGE;
import static com.example.demo.RabbitMQ.MessageConfig.ROUTING_KEY;

@Component
public class AdministrationController {



   @RabbitListener(queues = MessageConfig.QUEUE)
    public ResponseEntity<Object> addEstates(@RequestBody InventoryMQRequest inventoryMQRequest) throws Exception {
        try {

      //todo get the request and do the inventorying for the estates sales



        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>("massage :\"Error Bad Request\"", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("massage :\"Estates Add Successfully\"", HttpStatus.OK);

    }

}
