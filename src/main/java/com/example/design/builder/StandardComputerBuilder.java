package com.example.design.builder;

/**
 * description： 实现具体建造者（Concrete Builder）
 * time：2025/3/25 13:14
 * auther：zhaopengfei
 */
public class StandardComputerBuilder implements ComputerBuilder {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    @Override
    public ComputerBuilder setCPU(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public ComputerBuilder setRAM(String ram) {
        this.ram = ram;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(String storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder setGPU(String gpu) {
        this.gpu = gpu; // 可选步骤
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(cpu, ram, storage, gpu);
    }
}
