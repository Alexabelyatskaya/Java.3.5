package ru.netology.domain;

import lombok.Data;

@Data
public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String productName, int cost, String manufacturer) {
        super(id, productName, cost);
        this.manufacturer = manufacturer;
    }
}
