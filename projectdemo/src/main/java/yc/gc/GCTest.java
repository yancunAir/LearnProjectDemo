package yc.gc;

import java.util.ArrayList;
import java.util.List;

public class GCTest {


    public static void main(String[] args) {


        List<Object> list = new ArrayList<Object>();

        while(true){
            list.add(new GCTest());
        }


    }

}
