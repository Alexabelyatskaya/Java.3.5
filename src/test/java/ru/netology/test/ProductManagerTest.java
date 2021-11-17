package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product one = new Smartphone(1, "A-52", 26000, "Samsung");
    Product two = new Smartphone(2, "S-20", 45000, "Samsung");
    Product three = new Book(3, "Demon", 340, "Lermontov");
    Product four = new Book(4, "Skazky", 290, "Folklore");

    @BeforeEach
    public void adder() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
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
    public void shouldSearchSmartphoneManufacturer() {
        assertArrayEquals(manager.searchBy("Samsung"), new Product[]{one, two});
    }

    @Test
    public void shouldSearchSmartphoneName() {
        assertArrayEquals(manager.searchBy("A-52"), new Product[]{one});
    }

    @Test
    public void shouldSearchNone() {
        assertArrayEquals(manager.searchBy("123"), new Product[]{});
    }
}
