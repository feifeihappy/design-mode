package com.example.design.Observer.Product;

public class LaptopBuyer implements User {
    private int expectedPrice;
    private String userName;
    public LaptopBuyer(String userName, int expectedPrice) {
        this.userName = userName;
        this.expectedPrice = expectedPrice;
    }

    @Override
    public boolean isExpectedPrice(int curPrice) {
        // TODO Auto-generated method stub
        return curPrice <= expectedPrice;
    }

    @Override
    public void shortMSG(String msg) {
        // TODO Auto-generated method stub
        System.out.println("Your follow product have a low price: " + msg + " TO:" + userName);
    }

}