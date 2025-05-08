package com.example.design.Observer;

public class ConcreteObserver implements Observer {

    @Override
    public void update(String msg) {
        // TODO Auto-generated method stub
        System.out.println("ConcreteObserver receive notify msg: " + msg);
    }

}