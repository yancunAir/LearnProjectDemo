package yc.designpattern;


/**
 *
 * 代理模式
 *
 * 在有些情况下，一个客户不能或者不想直接访问另一个对象，这时需要找一个中介帮忙完成某项任务
 *软件设计中，使用代理模式的例子也很多，例如，要访问的远程对象比较大（如视频或大图像等），其下载要花很多时间。还有因为安全原因需要屏蔽客户端直接访问真实对象，如某单位的内部数据库等
 *
 *
 *
 * 扩展
 *
 * 在前面介绍的代理模式中，代理类中包含了对真实主题的引用，这种方式存在两个缺点。
 * 真实主题与代理主题一一对应，增加真实主题也要增加代理。
 * 设计代理以前真实主题必须事先存在，不太灵活。采用动态代理模式可以解决以上问题，如 SpringAOP，其结构图如图 4 所示
 *
 * 总结  在代理类中  构造器中传入真正的类  然后在重写接口方法中 去调用真正的类的方法
 *
 */
public class Proxy {


   public static void main(String[] args){

       ProxySubject proxySubject = new ProxySubject();
       proxySubject.request();
   }


}

interface Subject{
    void request();
}


class RealSubject implements Subject{

    public void request() {

        System.out.println("这个是真实对象访问");
    }
}


class ProxySubject implements Subject{

    private RealSubject realSubject;

    public void request() {

        System.out.println("这个是代理对象访问");

        if(realSubject == null){

            realSubject = new RealSubject();

        }
        realSubject.request();


    }
}














