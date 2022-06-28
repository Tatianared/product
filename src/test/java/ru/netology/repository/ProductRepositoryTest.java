package ru.netology.repository;

import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;
import ru.netology.domain.Product;

public class ProductRepositoryTest {
    Product product1 = new Product(1, "first", 100);
    Product product2 = new Product(2, "second", 200);
    Product product3 = new Product(3, "third", 300);
    private ArrayAsserts Assertions;


    @Test
    public void shouldAddProduct() {

        ProductRepository repository = new ProductRepository();
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        Product[] expected = {product1, product2, product3};

        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.removeById(product3.getId());
        Product[] expected = {product1, product2};

        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }
}
