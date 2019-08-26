package yc.designpattern;

/**
 * 适配器模式
 *
 * 该模式的主要优点如下。
 * 客户端通过适配器可以透明地调用目标接口。
 * 复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
 * 将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题。
 *
 */
public class Adapter implements Target,Adaptee{

    private Target target;

    private Adaptee adaptee;

    public Adapter(Target target){
        this.target = target;
    }

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    public void request() {
        target.request();
        adaptee.request();


    }
}


interface Target{

    void request();

}

class TargetImpl implements Target{

    public void request(){
        System.out.println("真实实现");
    }
}

interface Adaptee{
    void request();
}

class AdapteeImpl implements Adaptee{

    public void request(){
        System.out.println("适配者实现");
    }

}

