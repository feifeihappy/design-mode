package com.example.design.builder;

/**
 * description：TODO
 * time：2025/3/25 13:17
 * auther：zhaopengfei
 */
public class Client {
    public static void main(String[] args) {
        Computer gamingPC = new StandardComputerBuilder()
                .setCPU("Intel i9")
                .setRAM("32GB DDR5")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 4090") // 可选
                .build();

        Computer officePC = new StandardComputerBuilder()
                .setCPU("Intel i5")
                .setRAM("16GB DDR4")
                .setStorage("512GB SSD")
                .build(); // 不设置GPU
    }
}
