package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;
    private Product product;
    private String text;


    public ProductManager(ProductRepository repository) {
        this.repo= repository;
    }

    public void add(Product product) {
        repo.save(product);
    }




    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++)
                    tmp[result.length - 1] = product;
                result = tmp;
                // "добавляем в конец" массива result продукт product
            }

        }
        return result;

    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }


}