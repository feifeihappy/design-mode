package com.example.design.builder.inner;

/**
 * description：
 * 建造者模式的变体：静态内部类
 * 更简洁的实现方式（推荐）：
 * time：2025/3/25 13:25
 * auther：zhaopengfei
 */
public class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String gpu;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }

    public static class Builder {
        // 必填参数
        private final String cpu;
        private final String ram;
        private final String storage;
        // 可选参数
        private String gpu = ""; // 默认值

        public Builder(String cpu, String ram, String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public Builder setGPU(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }


    public static void main(String[] args) {
        // 使用方式
        Computer pc = new Computer.Builder("i7", "16GB", "512GB SSD")
                .setGPU("RTX 3080")
                .build();

        String string = new StringBuilder().append("hello").toString();
    }
}


