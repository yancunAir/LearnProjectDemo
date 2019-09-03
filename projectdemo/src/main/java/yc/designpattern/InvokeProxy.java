package yc.designpattern;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * JDK动态代理 只能代理接口  cglib代理 类和接口都可以
 *
 * 代理模式的主要优点有：
 * 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
 * 代理对象可以扩展目标对象的功能；
 * 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度
 *
 */
public class InvokeProxy implements InvocationHandler {

    private Object object;

    public InvokeProxy(){

    }

    public InvokeProxy(Object object){
       this.object = object;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return  method.invoke(this.object, args);

    }

    public Object bind(){
        return Proxy.newProxyInstance(this.object.getClass().getClassLoader(),this.object.getClass().getInterfaces(),new InvokeProxy(this.object));
    }



}

interface People{

    String say();
}

class Chinese implements People{


    public String  say(){

        return "China say Chiness";

    }
}


