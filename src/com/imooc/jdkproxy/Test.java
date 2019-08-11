package com.imooc.jdkproxy;

import com.imooc.proxy.Car;
import com.imooc.proxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理测试类
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();
        /**
         * ClassLoader loader, 类加载器
         * Class<?>[] interfaces, 实现接口
         * InvocationHandler h
         *
         *
         * 动态代理实现思路
         * 实现功能:通过Proxy的newProxyInstance返回代理对象
         * 1、声明一段源码(动态产生代理)
         * 2、编译源码(JDK Compiler API)，产生新的类(代理类)
         * 3、将这个类load到内存中，产生一个新的对象(代理对象)
         * 4、return 代理对象
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);

        System.out.println("代理类名字: " + m.getClass().getName());
        //输出 代理类名字: com.sun.proxy.$Proxy0
        m.move();

//        输出:
//        汽车开始行驶....
//        汽车行驶中...
//        汽车结束行驶....  汽车行驶时间：818毫秒！
    }
}
