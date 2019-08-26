package yc.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 指对象之间会一定的联系
 * 当一个对象改变时 其他的对象也会得到更新 这种对象又称 发布-订阅模式
 *
 * 观察者模式是一种对象行为型模式，其主要优点如下。
 * 降低了目标与观察者之间的耦合关系，两者之间是抽象耦合关系。
 * 目标与观察者之间建立了一套触发机制。
 *
 * 它的主要缺点如下。
 * 目标与观察者之间的依赖关系并没有完全解除，而且有可能出现循环引用。
 * 当观察者对象很多时，通知的发布会花费很多时间，影响程序的效率。
 */
public class ObserverMain {


    public static void main(String[] args){
        ObserverListImpl impl = new ObserverListImpl();

        impl.add(new ObserverOne());
        impl.add(new ObserverTwo());

        impl.response();


    }


}


interface Observer{
    void response();
}

class ObserverOne implements Observer{

    public void response(){
        System.out.println("观察者1响应");
    }
}

class ObserverTwo implements Observer{

    public void response(){
        System.out.println("观察者2响应");
    }
}

abstract class ObserverList{

    protected List<Observer> list = new ArrayList<Observer>();

    public void add(Observer observer){
        list.add(observer);
    }

    public void remove(Observer observer){
        list.remove(observer);
    }

    public abstract void response();

}

class ObserverListImpl extends ObserverList{

    @Override
    public  void response() {

        System.out.println("发生了变化");

        for(Observer observer: list){
            observer.response();
        }

    }
}
