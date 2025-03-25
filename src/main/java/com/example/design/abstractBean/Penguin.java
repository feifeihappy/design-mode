package com.example.design.abstractBean;

import org.springframework.stereotype.Service;

/**
 * description：TODO
 * time：2025/3/24 13:59
 * auther：zhaopengfei
 */
@Service
public class Penguin {
    private String name;
    private int id;

    public void eat(){
        System.out.println(name+"Penguin 正在吃");
    }
    public void sleep(){
        System.out.println(name+"正在睡");
    }
    public void introduction() {
        System.out.println("大家好！我是"         + id + "号" + name + ".");
    }
}
