package com.example.demo.dto.request;

import java.io.Serializable;

public class EstatesFilterObject implements Serializable {
    String estate_name;
     Double price;
    Double stock_count;

    public EstatesFilterObject() {
    }

    public String getEstate_name() {
        return estate_name;
    }

    public void setEstate_name(String estate_name) {
        this.estate_name = estate_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getStock_count() {
        return stock_count;
    }

    public void setStock_count(Double stock_count) {
        this.stock_count = stock_count;
    }
}
