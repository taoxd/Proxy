package com.imooc.proxy;

/**
 * @Description: 测试类
 * @Author: taoxudong
 * @CreateDate: 2019/8/9 14:03
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        CarTimeProxy ctp = new CarTimeProxy(car);
        CarLogProxy clp = new CarLogProxy(ctp);
        clp.move();

//        输出:
//        日志开始....
//        汽车开始行驶....
//        汽车行驶中...
//        汽车结束行驶....  汽车行驶时间：608毫秒！
//        日志结束....
    }
}

