package com.in28minutes.jpa.hibernate.demo5.entity;

import javax.persistence.*;

@Entity(name = "products")
@Table (name = "products")
public class Products {
    @Id
    private int id;
    private String name;
    private String manufacturer;
    private int price;

    public Products() {

    }

    public Products(int id, String name, String manufacturer, int price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + this.id +
                ", name='" + this.name + "'''" +
                ", manufacture='" + this.manufacturer + "'''" +
                ", price='" + this.price + "'''" +
                "}";
    }
}
