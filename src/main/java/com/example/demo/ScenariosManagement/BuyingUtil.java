package com.example.demo.ScenariosManagement;

import com.example.demo.Excptions.AnotherProcessOfBuyingIsInUse;
import com.example.demo.enums.SaleType;

public class BuyingUtil {


    public static boolean   ValidateBuyingProcess(SaleType type){

        if (type.getSaleType().equalsIgnoreCase("pending"))
            throw new AnotherProcessOfBuyingIsInUse("Sorry This Estates Already has been sold!");
        else
            return true;

    }



}
