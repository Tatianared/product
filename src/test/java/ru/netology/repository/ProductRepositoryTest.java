package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product product1 = new Product(1, "first", 100);
    Product product2 = new Product(2, "second", 200);
    Product product3 = new Product(3, "third", 300);



    @Test
    public void shouldAddProduct() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        Product[] expected = {product1, product2, product3};

        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldRemoveById() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.removeById(product3.getId());
        Product[] expected = {product1, product2};

        Product[] actual = repository.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldNotFindById() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);


        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });

    }
}
