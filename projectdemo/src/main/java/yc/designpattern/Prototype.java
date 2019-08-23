package yc.designpattern;

/**
 * 原型模式
 * 以一个实例为基准 复制出其他的实例
 * 类需要实现Clnoeable接口并重写clone方法
 * 实用场景:针对创建对象比较麻烦  复制对象比较简单的情况
 * 复制之后 还可以改变类的属性
 *
 */

public class Prototype implements Cloneable{


    private String name ;

    private String email;

    private String address;

    Prototype(){
        System.out.println("创建原型成功");
    }

    Prototype(String name , String email , String address){
        this.name = name ;
        this.email = email ;
        this.address = address ;
    }

    @Override
    public Object clone(){
        try {
            System.out.println("复制原型成功");
            return super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    public void setName(String name){
        this.name = name ;
    }

    public String getName(){
        return this.name;
    }

    public void display(){
        System.out.println("姓名:"+name+","+"邮箱:"+email+","+"住址:"+address+"。");
    }

    public static void main(String[] args){

        Prototype prototype = new Prototype();
        Prototype prototype1 = (Prototype)prototype.clone();

        Prototype prototype2 = new Prototype("张三","15423654523","湖南张家界");
        prototype2.display();
        Prototype prototype3 = (Prototype)prototype2.clone();
        prototype3.setName("李四");
        prototype3.display();


    }

}
