package myaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sanske
 * @date 2018/7/19 上午11:29
 **/
public class AOPHandle implements InvocationHandler {
    private Object obj;
    public AOPHandle(Object obj) {
      this.obj = obj;
    }
     @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      System.out.println("前置代理！");
      //j将代理类、代理方法、参数整合在一起
      Object ret = method.invoke(obj, args);
      System.out.println("后置代理");
      return ret;
    }


}
