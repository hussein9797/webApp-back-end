package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
//todo create repo and services for this model and handel sales from the controller
@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    Long id;
    @Column(name = "sale_date")
    private
    Date sellDate;
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JoinColumn(name="user_id")
    User user;
    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JoinColumn(name="estate_id")
    Estates Estates;
    @Version
    private Long version;

    public Sales() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.example.demo.Model.Estates getEstates() {
        return Estates;
    }

    public void setEstates(com.example.demo.Model.Estates estates) {
        Estates = estates;
    }
}
