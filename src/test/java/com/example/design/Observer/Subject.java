package com.example.design.Observer;

//　抽象被观察者，仅提供注册和删除观察者对象的接口声明
public interface Subject {
    // 设置状态
    public void setState(int state);
    // 获取状态
    public int getState();
    // 添加
    public void attach(Observer obs);
    // 删除
    public void detach(Observer obs);
    // 通知
    public void notify(String msg);
}