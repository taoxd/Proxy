package com.imooc.cglibproxy;

public class Client {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.move();

//        输出:
//        日志开始...
//        火车行驶中...
//        日志结束...
    }
}
