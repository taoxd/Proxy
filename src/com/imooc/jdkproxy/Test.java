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
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        m.move();

//        输出:
//        汽车开始行驶....
//        汽车行驶中...
//        汽车结束行驶....  汽车行驶时间：818毫秒！
    }
}
