package com.in28minutes.jpa.hibernate.demo5.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    private int id;
    private String name;

    @OneToMany
    private List<Orders> orders;
    public Customer(){}

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
