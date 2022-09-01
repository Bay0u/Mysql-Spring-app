package com.in28minutes.jpa.hibernate.demo5.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {
    @Id
    private int id;
    private int total_price;
    private boolean checkout;
    private int customer_id;

    @ManyToMany
    private List<OrderDetails> detailsList;

    public Orders() {
    }

    public Orders(int id, int total_price, boolean checkout, int customer_id) {
        this.id = id;
        this.total_price = total_price;
        this.checkout = checkout;
        this.customer_id = customer_id;
    }

    public List<OrderDetails> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(List<OrderDetails> detailsList) {
        this.detailsList = detailsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
