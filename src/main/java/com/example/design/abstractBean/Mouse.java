package com.example.design.abstractBean;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description：TODO
 * time：2025/3/24 13:59
 * auther：zhaopengfei
 */
@Service
public class Mouse extends Animal {
    private String name;
    private int id;
    private StringBuilder ids;


    @Transactional
    public void eat(){

        StringBuilder stringBuilder = new StringBuilder("abc");
        super.eat();
        System.out.println(name+"Mouse  正在吃");
    }
    public void sleep(){
        System.out.println(name+"正在睡");
    }
    public void introduction() {
        System.out.println("大家好！我是"         + id + "号" + name + ".");
    }
}
