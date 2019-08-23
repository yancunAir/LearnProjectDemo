package yc.designpattern;

/**
 * 工厂方法模式
 */

public class FactoryMethod {



    public static void main(String[] args){

        FactoryMethod fm = new FactoryMethod();

        Factroy factroy  = fm.getFactory(1);
        factroy.say("method1");
        Factroy factroy2  = fm.getFactory(2);
        factroy2.say("method2");



    }


    public Factroy getFactory(int type){

        switch(type){
            case 1:
                return new AFactory();
            case 2:
                return new BFactory();
            default:
                return null;
        }
    }


}

interface Factroy{

    void say(String name);

}


class AFactory implements Factroy{
    public void say(String name){
        System.out.println("I AM AFactroy:"+name);
    }
}

class BFactory implements Factroy{
    public void say(String name){
        System.out.println("I AM BFactroy:"+name);
    }
}
