package yc.designpattern;

/**
 * 单例模式
 *
 * 1.双重锁的懒汉
 *
 * 2.饿汉
 *
 */

public class Singleton {


    //1 推荐
    public static volatile Singleton singleton;


    public static Singleton getInstance(){
        synchronized (Singleton.class){
            if(singleton == null){
                synchronized (Singleton.class){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    //2 不推荐
    private static final Singleton singleton2 = new Singleton();

    public static Singleton getInstance2(){
        return singleton2;
    }


}
