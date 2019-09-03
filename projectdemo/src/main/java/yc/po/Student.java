package yc.po;

import lombok.Data;

import java.util.Comparator;

@Data
public class Student implements Comparator {

    private Integer age;

    private String name;

    @Override
    public int compare(Object o1, Object o2) {
        return 1;
    }
}
