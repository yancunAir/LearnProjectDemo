package yc.designpattern;


public class InvokeProxyDemo {

    public static void main(String[] args){

        People people = new Chinese();

        InvokeProxy handler = new InvokeProxy(people);

        People people2  =(People) handler.bind();

        System.out.println(people2.say());

    }















}
