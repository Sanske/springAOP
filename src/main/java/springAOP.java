
import Entity.User;
import Impl.ManSayHelloWorld;
import cglib.CglibProxy;
import cglib.SayHello;
import core.BeanFactory;
import core.ClassPathXmlApplicationContext;
import dao.ISayHelloWorld;
import myaop.AOPHandle;

import java.lang.reflect.Proxy;

/**
 * @author sanske
 * @date 2018/7/16 下午2:05
 **/
public class springAOP {
    public static void main(String[] args) {
       //通过对象注入代理类，用代理类调用对象的方法
       //testIOC();
       //sdkProxy();
        cgligProxy();
    }

    private static void testIOC() {
        BeanFactory bf = new ClassPathXmlApplicationContext("./src/main/java/ApplicationContext.xml");
        User user = (User) bf.getBean("user");
        System.out.println(user);
        System.out.println("address hashcode:" + user.getAddress().hashCode());
    }

    //通过内置对象代理
    private static void sdkProxy() {
        ManSayHelloWorld sayHelloWorld = new ManSayHelloWorld();
        AOPHandle aopHandle = new AOPHandle(sayHelloWorld);
        //使用Object则用强转化
        ISayHelloWorld i = (ISayHelloWorld) Proxy.newProxyInstance(ManSayHelloWorld.class.getClassLoader(), new Class[]{ISayHelloWorld.class}, aopHandle);
        i.say();
        i.say1();
    }

    // 通过cglib来实现代理
    private static void cgligProxy() {
      CglibProxy proxy = new CglibProxy();
      SayHello proxyImp = (SayHello)proxy.getProxy(SayHello.class);
      proxyImp.say();

    }
}

