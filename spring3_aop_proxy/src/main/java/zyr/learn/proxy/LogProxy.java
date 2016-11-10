package zyr.learn.proxy;

import zyr.learn.model.LogInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhouweitao on 2016/11/4.
 */
//1.创建一个实现invocationHandler的类
public class LogProxy implements InvocationHandler {

    private LogProxy() { }

    //2.创建一个代理对象
    private Object target;


    //3.创建一个方法，参数为需要代理的对象，返回的是代理对象
    private static Object getInstance(Object o) {
        //3.1创建代理对象
        LogProxy proxy = new LogProxy();
        //3.2设置这个需要代理的对象
        proxy.target = o;
        //3.3调用Proxy.newProxyInstance方法创建已代理的对象
        Object result = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), proxy);
        //
        return result;
    }
    //
    //

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /*if (method.getName().equals("addMsg")) {
            Logger.info("info log -->"+target.getClass().getName());
        }*/

        if (method.isAnnotationPresent(LogInfo.class)) {
            LogInfo li = method.getAnnotation(LogInfo.class);
            Logger.info(li.value());

        }
        Object obj = method.invoke(target, args);
        return obj;
    }
}
