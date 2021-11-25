package com.example.demo.dto.MessagesQRequsts;

import java.io.Serializable;
import java.util.Date;

public class InventoryMQRequest implements Serializable {


    String email;
    String content;
    Date inventoryingDate;

    public InventoryMQRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInventoryingDate() {
        return inventoryingDate;
    }

    public void setInventoryingDate(Date inventoryingDate) {
        this.inventoryingDate = inventoryingDate;
    }
}
