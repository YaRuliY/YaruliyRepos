package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orderu")
public class Order implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "buyDate")
    private String buyDate;

    public String getBuyDate() {
        return buyDate;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
}