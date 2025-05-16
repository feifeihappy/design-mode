package com.example.design.Proxy.CGLib;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Method;

public class AsmExample {
    public static void main(String[] args) throws Exception {
        // 创建ClassWriter对象，COMPUTE_MAXS表示自动计算栈帧大小和局部变量表大小
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        
        // 定义类的基本信息：Java版本、访问标志、类名、签名、父类、接口
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "ExampleClass", null, "java/lang/Object", null);
        
        // 创建构造函数
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
        
        // 创建add方法
        mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "add", "(II)I", null, null);
        mv.visitVarInsn(Opcodes.ILOAD, 1); // 加载第一个参数
        mv.visitVarInsn(Opcodes.ILOAD, 2); // 加载第二个参数
        mv.visitInsn(Opcodes.IADD); // 执行加法操作
        mv.visitInsn(Opcodes.IRETURN); // 返回操作
        mv.visitMaxs(2, 3); // 设置栈帧和局部变量表大小
        mv.visitEnd();
        
        // 完成类的定义
        cw.visitEnd();
        
        // 获取定义的类的字节码数组
        byte[] b = cw.toByteArray();
        
        // 使用自定义类加载器加载这个类
        MyClassLoader loader = new MyClassLoader();
        Class<?> exampleClass = loader.defineClass("ExampleClass", b);
        
        // 使用反射调用add方法
        Object obj = exampleClass.newInstance();
        Method addMethod = exampleClass.getMethod("add", int.class, int.class);
        Object result = addMethod.invoke(obj, 5, 3);
        
        System.out.println("5 + 3 = " + result);
    }
    
    static class MyClassLoader extends ClassLoader {
        public Class<?> defineClass(String name, byte[] b) {
            return super.defineClass(name, b, 0, b.length);
        }
    }
}
