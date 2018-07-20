package Impl;

import dao.ISayHelloWorld;

/**
 * @author sanske
 * @date 2018/7/19 上午11:27
 **/
public class ManSayHelloWorld implements ISayHelloWorld {

    @Override
    public String say() {
      System.out.println("Hello world!");
      return "say";
    }

    @Override
    public String say1() {
      System.out.println("hello world2");
      return "say1";
    }
}
