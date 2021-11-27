package com.example.demo.Model;

import com.example.demo.enums.SaleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estates")
public class Estates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estate_id")
    Long id;
    @Column(name = "name")
    private
    String  name;
    @Column(name = "stock_price")
    private
    double stockPrice;

    @Column(name = "stock_count")
    private
    double stockCount;
    @JsonIgnore
    @Column(name = "sell_date")
    private
    Date sellDate;
    @Column(name = "selling_price")
    private
    double sellingPrice;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JoinColumn(name="user_id")
    User user;
    @Column(name = "investor_name")
    private
    String investorName;

    @Column(name = "sale_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private SaleType saleType;
    @Column(name = "created_at")
    private
    Date createdAt;
    @Column(name = "created_by")
    private
    String createdBy;
    @Column(name = "updated_at")
    private
    Date updatedAt;
    @Column(name = "updated_by")
    private
    String updatedBy;


    public Estates() {
    }

    public SaleType getSaleType() {
        return saleType;
    }

    public void setSaleType(SaleType saleType) {
        this.saleType = saleType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public double getStockCount() {
        return stockCount;
    }

    public void setStockCount(double stockCount) {
        this.stockCount = stockCount;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
