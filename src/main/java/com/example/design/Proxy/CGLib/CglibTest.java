package com.example.design.Proxy.CGLib;

import com.example.design.Proxy.jdkProxy.Zhangsan;
import net.sf.cglib.core.DebuggingClassWriter;

public class CglibTest {
    public static void main(String[] args) {
        try {
            //使用CGLib的代理类可以将内存中的.class文件写入本地磁盘
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/zhaopengfei/project/github-project/design-mode/com/sun/proxy");
            Zhangsan obj = (Zhangsan) new CustomCGlib().getInstance(Zhangsan.class);
            obj.learn();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
