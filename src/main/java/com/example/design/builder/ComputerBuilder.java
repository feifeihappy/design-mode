package com.example.design.builder;

/**
 * description：定义建造者接口（Builder）
 * time：2025/3/25 13:12
 * auther：zhaopengfei
 */
public interface ComputerBuilder {
    ComputerBuilder setCPU(String cpu);
    ComputerBuilder setRAM(String ram);
    ComputerBuilder setStorage(String storage);
    ComputerBuilder setGPU(String gpu);
    Computer build();
}
