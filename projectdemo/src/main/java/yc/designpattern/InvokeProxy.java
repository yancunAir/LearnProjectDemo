package yc.designpattern;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * JDK动态代理 只能代理接口  cglib代理 类和接口都可以
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


