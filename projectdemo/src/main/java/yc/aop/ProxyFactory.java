package yc.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private Object target;
    private BeforeAdvice beforeAdvice;
    private AfterAdvice afterAdvice;


    public Object createProxy() {

        ClassLoader loader = this.getClass().getClassLoader();

        Class<?>[] interfaces = this.target.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {

                if (beforeAdvice != null) {
                    beforeAdvice.before();
                }

                Object targetObject = method.invoke(target,args);

                afterAdvice.after();

                return targetObject;

            }
        };

        Object object = Proxy.newProxyInstance(loader,interfaces,handler);

        return object;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }
}
