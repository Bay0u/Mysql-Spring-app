package com.in28minutes.jpa.hibernate.demo5.entity;

import javax.persistence.*;

@Entity
public class OrderDetails {
    private int price;
    private int product_id;
    @Id
    private int order_id;

    public OrderDetails() {
    }

    public OrderDetails(int price,  int product_id, int order_id) {
        this.price = price;
        this.product_id = product_id;
        this.order_id = order_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
