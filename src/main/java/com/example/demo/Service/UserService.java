package com.example.demo.Service;

import com.example.demo.dto.request.UserRegisterRequest;

public interface UserService {

    void registerUser(UserRegisterRequest userRegisterRequest) throws Exception;

     boolean checkIfUserExist(String email);


}
