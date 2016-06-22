package com.els.tvstore;

/**
 * Created by ericaschulz on 6/22/16.
 */
public class televisions {
    public int id;
    public String brand;
    public String size;
    public int price;


    public televisions(int id, String brand, String size, int price) {
        this.id = id;
        this.brand = brand;
        this.size = size;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}


