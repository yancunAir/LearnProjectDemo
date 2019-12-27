package yc.thread;

import java.util.concurrent.Callable;

public class MyThreadDemo implements Callable<String> {

    private int num;

    public MyThreadDemo(int num) {
        this.num = num;
    }

    @Override
    public String call() throws Exception {

        Long currentTime = System.currentTimeMillis();
        System.out.println("thread start...");
        Thread.sleep(2000L);
        System.out.print("thread time speed");
        System.out.println(System.currentTimeMillis()-currentTime);
        return "success" + this.num;
    }
}
