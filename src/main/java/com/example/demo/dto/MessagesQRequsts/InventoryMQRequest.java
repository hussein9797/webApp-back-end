package com.example.demo.dto.MessagesQRequsts;

import java.io.Serializable;
import java.util.Date;

public class InventoryMQRequest implements Serializable {


    String email;
    String content;
    Date inventorying_date;

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

    public Date getInventorying_date() {
        return inventorying_date;
    }

    public void setInventorying_date(Date inventorying_date) {
        this.inventorying_date = inventorying_date;
    }
}
