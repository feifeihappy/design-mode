package com.example.design.Observer.Product;

public class Demo {
    public static void main(String[] args) {
        LaptopBuyer Alice = new LaptopBuyer("Alice", 6000);
        LaptopBuyer Jack = new LaptopBuyer("Jack", 6500);
        Laptop laptop = new Laptop();
        laptop.follow(Alice);
        laptop.follow(Jack);
        laptop.setPrice(7000);
        laptop.setPrice(6500);
        laptop.setPrice(6000);
        laptop.unfollow(Jack);
        laptop.setPrice(5999);
        laptop.setPrice(6099);
    }
}