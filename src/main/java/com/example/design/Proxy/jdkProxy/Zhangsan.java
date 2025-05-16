package com.example.design.Proxy.jdkProxy;

/**
* 真实调用类
*/
public class Zhangsan implements IPerson {
    public final void learn() {
        System.out.println("==张三学习中间件==");
        test();
    }
    public final  void test() {
        System.out.println("==哈哈==");
    }
}