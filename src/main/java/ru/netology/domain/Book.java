package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String productName, int cost, String author) {
        super(id, productName, cost);
        this.author = author;
    }
}
