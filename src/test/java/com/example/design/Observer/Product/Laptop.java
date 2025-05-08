package com.example.design.Observer.Product;

import java.util.ArrayList;
import java.util.List;

public class Laptop implements Product {
    
    private List<User> followList = new ArrayList<User>();
    private int curPrice;

    @Override
    public void setPrice(int price) {
        curPrice = price;
        System.out.println("set laptop price: " + price);
        notifyLowPrice();
    }

    @Override
    public int getPrice() {
        return curPrice;
    }
    
    @Override
    public void follow(User user) {
        followList.add(user);
    }

    @Override
    public void unfollow(User user) {
        followList.remove(user);
    }

    @Override
    public void notifyLowPrice() {
        String msg = "" + curPrice;
        for (User user: followList) {
            if (user.isExpectedPrice(curPrice)) {
                user.shortMSG(msg);
            }
        }
    }
}