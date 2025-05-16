package com.example.design.Proxy.jdkProxy;

/**
* 测试
*/
public class Test {
    public static void main(String[] args) {
        CustomInvocationHandler custom = new CustomInvocationHandler();
        IPerson zhangsan = custom.getInstance(new Zhangsan());
        zhangsan.learn();
    }
}