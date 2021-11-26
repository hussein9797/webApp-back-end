package com.example.demo.enums;

public enum SaleType {
    SOLD("sold"),
    ON_SALE("on_sale");

    private  String saleType;

    SaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getSaleType() {
        return saleType;
    }
}
