package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orderproducts")
public class OrderProducts implements Serializable{
    @Id
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "cost")
    private int cost;

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getCost() {
        return cost;
    }
}