//package com.example.design.abstractBean;
//
//import jakarta.annotation.Resource;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * description：TODO
// * time：2025/3/24 13:59
// * auther：zhaopengfei
// */
//
//public abstract class Animal {
//    private String name;
//    private int id;
//
//    @Resource
//    private Penguin penguin;
//
//    @Transactional
//    public void eat(){
//        penguin.eat();
//        System.out.println(name+"Animal 正在吃");
//    }
//    public void sleep(){
//        System.out.println(name+"正在睡");
//    }
//    public void introduction() {
//        System.out.println("大家好！我是"         + id + "号" + name + ".");
//    }
//}
