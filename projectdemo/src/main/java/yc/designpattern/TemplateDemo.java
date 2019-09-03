package yc.designpattern;


/**
 * 模板模式
 *
 * 对于相同的操作部分 可以在父类定义一个模板
 *  不同的部分在子类中去实现
 *
 * 该模式的主要优点如下。
 * 它封装了不变部分，扩展可变部分。它把认为是不变部分的算法封装到父类中实现，而把可变部分算法由子类继承实现，便于子类继续扩展。
 * 它在父类中提取了公共的部分代码，便于代码复用。
 * 部分方法是由子类实现的，因此子类可以通过扩展方式增加相应的功能，符合开闭原则。
 *
 * 模板方法模式通常适用于以下场景。
 * 算法的整体步骤很固定，但其中个别部分易变时，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现。
 * 当多个子类存在公共的行为时，可以将其提取出来并集中到一个公共父类中以避免代码重复。首先，要识别现有代码中的不同之处，并且将不同之处分离为新的操作。最后，用一个调用这些新的操作的模板方法来替换这些不同的代码。
 * 当需要控制子类的扩展时，模板方法只在特定点调用钩子操作，这样就只允许在这些点进行扩展
 *
 *
 *  总结 就是一个抽象类 定义了一些方法  然后父类去重写某些方法
 *
 */
public class TemplateDemo {


    public static void main(String[] args){
        StudyTemplate template = new StudyTemplateImpl();
        template.templateMethod();



    }


}

abstract class StudyTemplate {

    public void templateMethod(){
       templateA();
       templateB();
       templageC();
    }
    void templateA(){
        System.out.println("这个是模板方法A");
    }
    void templateB(){
        System.out.println("这个是模板方法B");
    }
    void templageC(){
        System.out.println("这个是模板方法C");
    }

}

class StudyTemplateImpl extends StudyTemplate{

    @Override
    public void  templageC(){
        System.out.println("这个是重写之后的模板方法C");
    }


}

