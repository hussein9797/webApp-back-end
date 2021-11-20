package com.example.demo.Controller.User;

import com.example.demo.Service.UserDetailsServiceImpl;
import com.example.demo.dto.request.UserRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_management")
public class UserManagementsController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/user_register")
    ResponseEntity<Object>  userRegister(@RequestBody UserRegisterRequest userRegisterRequest) throws Exception {
        try {
         userDetailsService.registerUser(userRegisterRequest);
            return new ResponseEntity<>("massage :\"Registered Successfully\"", HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("UserName Already Exist Please Choose Another UserName  ", HttpStatus.CONFLICT);


        }


    }
}
