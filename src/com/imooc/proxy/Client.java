package com.imooc.proxy;

/**
 * @Description: 测试类
 * @Author: taoxudong
 * @CreateDate: 2019/8/9 14:03
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);

        Moveable m = (Moveable) Proxy.newProxyInstance(Moveable.class, h);
        m.move();
    }
}

