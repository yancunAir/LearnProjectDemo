package yc.util;

import yc.po.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda {


    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        //Map<Integer, List<Student>> studentListMap = lambda.listlambda();
        //lambda.lamdbaFunction();
        //System.out.println(lambda.listFilterLambda());

        List<String> stringList = Arrays.asList("111","222","333","444");

        stringList.forEach(n-> {
            if(n.equals("111")){
                System.out.println("this is 111");
            }else {
                System.out.println("this is tusj");
            }
        });


    }


    private void lamdbaFunction() {
        MathOperation math = (int a, int b) -> {
            return a + b;
        };
        System.out.println(math.operate(1, 2));

    }


    private void listlambda() {

        List<Student> studentList = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setAge(10);
        student1.setName("张张");
        Student student2 = new Student();
        student2.setAge(20);
        student2.setName("丽丽");
        Student student3 = new Student();
        student2.setAge(15);
        student2.setName("等等");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);






    }

    public List<String> listFilterLambda(){

        List<String> stringList = Arrays.asList("Yuki","Sumi","","kuqi","","zhali");
        List<String> filerList =  stringList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());


        return filerList;

    }

}

interface MathOperation {

    int operate(int a, int b);
}