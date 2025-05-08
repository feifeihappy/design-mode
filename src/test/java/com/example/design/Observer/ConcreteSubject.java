package com.example.design.Observer;

import java.util.ArrayList;
import java.util.List;

//　具体被观察者对象，该对象中收集了所有需要被通知的观察者，并可以动态的增删集合中的观察者。
// 当其状态发生变化时会通知所有观察者对象。
public class ConcreteSubject implements Subject {
    
    private List<Observer> observerList = new ArrayList<Observer>();
    private int state;

    @Override
    public void setState(int state) {
        this.state = state;        
        notify("new state: " + state);
    }

    @Override
    public int getState() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void attach(Observer obs) {
        // TODO Auto-generated method stub
        observerList.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        // TODO Auto-generated method stub
        observerList.remove(obs);
    }

    @Override
    public void notify(String msg) {
        // TODO Auto-generated method stub
        for (Observer obs: observerList) {
            obs.update(msg);
        }
    }
}