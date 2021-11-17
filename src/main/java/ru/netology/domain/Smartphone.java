package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
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
