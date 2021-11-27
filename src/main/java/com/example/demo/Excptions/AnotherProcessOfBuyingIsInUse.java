package com.example.demo.Excptions;

public class AnotherProcessOfBuyingIsInUse extends RuntimeException {
    public AnotherProcessOfBuyingIsInUse(String message){
        super(message);
    }
}
