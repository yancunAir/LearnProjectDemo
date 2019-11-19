package yc.aop;

public class ProxyDemo {



    public void demo() {

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(new ChinesePeople());

        BeforeAdvice beforeAdvice = new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("before ...");
            }

        };

        AfterAdvice afterAdvice = new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("after ...");
            }
        };
        proxyFactory.setBeforeAdvice(beforeAdvice);
        proxyFactory.setAfterAdvice(afterAdvice);

        People people = (People) proxyFactory.createProxy();

        people.say();

    }

    public static void main(String[] args) {

        ProxyDemo demo = new ProxyDemo();
        demo.demo();;

    }

}
