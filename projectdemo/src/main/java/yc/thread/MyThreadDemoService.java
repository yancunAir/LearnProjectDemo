package yc.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThreadDemoService {


    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newFixedThreadPool(20);

        List<MyThreadDemo> myThreadList = new ArrayList<>();
        myThreadList.add(new MyThreadDemo(1));
        myThreadList.add(new MyThreadDemo(2));
        myThreadList.add(new MyThreadDemo(3));
        myThreadList.add(new MyThreadDemo(4));
        myThreadList.add(new MyThreadDemo(5));



        executorService.execute(()->{

            MyThreadDemo demo = new MyThreadDemo(100);
            try {
                demo.call();
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        long stat = System.nanoTime();

        List<Future<String>> futures =  executorService.invokeAll(myThreadList);
        long end = System.nanoTime();

        System.out.println("用时"+(end-stat));

    }

}
