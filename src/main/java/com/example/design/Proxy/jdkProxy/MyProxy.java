package com.example.design.Proxy.jdkProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 自己实现的代理类，用来生成字节码文件，并动态加载到JVM中
 */
public class MyProxy {

    public static final String ln = "\r\n";

    /**
     * 生成代理对象
     * @param classLoader 类加载器，用于加载被代理类的类文件
     * @param interfaces 被代理类的接口
     * @param h 自定义的InvocationHandler接口,用于具体代理方法的执行
     * @return 返回被代理后的代理对象
     */
    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h) {
        try {
        //1、动态生成源代码.java文件
            String src = generateSrc(interfaces);
        //2、Java文件输出磁盘
            String filePath = MyProxy.class.getResource("").getPath();

            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

        //3、把生成的.java文件编译成.class文件
            //获取Java编译器
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            //标注Java文件管理器，用来获取Java字节码文件
            StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manage.getJavaFileObjects(f);
            //创建task，通过java字节码文件将类信息加载到JVM中
            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
            //开始执行task
            task.call();
            //关闭管理器
            manage.close();

        //4、编译生成的.class文件加载到JVM中来
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();

        //5、返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成代理类的源代码
     */
    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(MyProxy.class.getPackage() + ";" + ln);
        sb.append("import " + interfaces[0].getName() + ";" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("GPInvocationHandler h;" + ln);
        sb.append("public $Proxy0(GPInvocationHandler h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);
        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
        sb.append("}" + ln);
        return sb.toString();
    }


    private static Map<Class, Class> mappings = new HashMap<Class, Class>();

    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
