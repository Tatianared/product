package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book book1 = new Book(1, "first", 100, "aaa");
    Book book2 = new Book(2, "second", 200, "bbb");
    Book book3 = new Book(3, "third", 300, "bbb");
    Smartphone phone1 = new Smartphone(4, "forth", 400, "ddd");
    Smartphone phone2 = new Smartphone(5, "fifth", 500, "ddd");
    Smartphone phone3 = new Smartphone(6, "sixth", 600, "fff");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
    }

    @Test
    public void shouldFindBook() {
        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("bbb");
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFindPhone() {
        Product[] expected = {phone1, phone2};
        Product[] actual = manager.searchBy("ddd");
        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void shouldFindPhoneName() {
        Product[] expected = {phone3};
        Product[] actual = manager.searchBy("sixth");
        Assertions.assertArrayEquals(expected, actual);
    }


}

