package yc.util;

import yc.po.Student;

import java.util.Optional;

public class OptionalUtil {

    public static void main(String[] args) {
        OptionalUtil optionalUtil = new OptionalUtil();
        optionalUtil.demo();
    }

    public void demo() {
        Student studentVo = new Student();
        studentVo.setAge(20);
        studentVo.setName("yancun");
        Optional.of(studentVo).ifPresent(s -> {
            System.out.println(s.getName());
        });
    }


}
