package com.example.demo.dto.request;

import java.io.Serializable;
import java.util.Date;

public class EstatesRequest implements Serializable {

    private Long id;

    private String  name;

    private double stock_price;

    private Integer stock_count;

    private Date sell_date;

    private double selling_price;
    private String investor_name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStock_price() {
        return stock_price;
    }

    public void setStock_price(double stock_price) {
        this.stock_price = stock_price;
    }

    public Integer getStock_count() {
        return stock_count;
    }

    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
    }

    public Date getSell_date() {
        return sell_date;
    }

    public void setSell_date(Date sell_date) {
        this.sell_date = sell_date;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

    public String getInvestor_name() {
        return investor_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInvestor_name(String investor_name) {
        this.investor_name = investor_name;
    }
}
