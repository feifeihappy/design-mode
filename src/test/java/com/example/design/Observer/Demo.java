package com.example.design.Observer;

public class Demo {
    public static void main(String[] args) {
        ConcreteObserver obs = new ConcreteObserver();
        ConcreteSubject sub = new ConcreteSubject();
        sub.attach(obs);
        sub.setState(666);
        sub.notify("just test subject notify function!");
    }
}