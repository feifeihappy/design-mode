package com.example.design.Proxy.jdkProxy;

/**
* 测试
*/
public class TestProxy {
    public static void main(String[] args) {
        try {
            //把生成的字节码保存到本地磁盘,动态生成的类会保存在工程根目录下的 com/sun/proxy 目录里面
            System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
            IPerson obj = (IPerson) new JdkInvocationHandler().getInstance(new Zhangsan());
            obj.learn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}