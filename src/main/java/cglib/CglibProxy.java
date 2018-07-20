package cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sanske
 * @date 2018/7/20 上午10:41
 **/
public class CglibProxy implements MethodInterceptor {
  private Enhancer enhancer = new Enhancer();

  public Object getProxy(Class clazz) {
     enhancer.setSuperclass(clazz);
     enhancer.setCallback(this);
     return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
      System.out.println("前置代理");
      Object result = methodProxy.invokeSuper(o, objects);
      System.out.println("后置代理");
      return result;

  }
}
