package com.example.design.builder;

/**
 * description：定义产品类（Product）
 * time：2025/3/25 13:11
 * auther：zhaopengfei
 */
public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu; // 可选参数

    public Computer(String cpu, String ram, String storage, String gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
    }

    // 省略getter方法
}
