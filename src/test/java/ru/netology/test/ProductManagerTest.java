package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductManager manager = new ProductManager();

    Product one = new Smartphone(1, "A-52", 26000, "Samsung");
    Product two = new Smartphone(2, "S-20", 45000, "Samsung");
    Product three = new Book(3, "Demon", 340, "Lermontov");
    Product four = new Book(4, "Skazky", 290, "Folklore");

    @BeforeEach
    public void Adder() {
        manager.addItem(one);
        manager.addItem(two);
        manager.addItem(three);
        manager.addItem(four);
    }

    @Test
    public void shouldSearchBookByAuthor() {
        assertArrayEquals(manager.searchBy("Lermontov"), new Product[]{three});
    }

    @Test
    public void shouldSearchBookByName() {
        assertArrayEquals(manager.searchBy("Skazky"), new Product[]{four});
    }

    @Test
    public void shouldSearchSmartphone() {
        assertArrayEquals(manager.searchBy("Samsung"), new Product[]{one, two});
    }

    @Test
    public void shouldSearchNone() {
        assertArrayEquals(manager.searchBy("123"), new Product[]{});
    }
}
