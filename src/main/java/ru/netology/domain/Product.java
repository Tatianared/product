package ru.netology.domain;
public class Product {
    public int length;
    protected int id;
    protected String name;
    protected int price;

    public Product (int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
