package yc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo {


    private static ExecutorService executorService = ThreadPoolExecutorUtil.getThreadPoolExecutor(4,20,
            2000L,TimeUnit.SECONDS,200,"My Thread.");

    public static void main(String[] args) {
        MyThreadPoolDemo.invokeThreadPool();;
    }

    public static void invokeThreadPool() {
        executorService.execute(()->{
            System.out.println("当前线程: "+Thread.currentThread().getName());
            for(int i = 0 ; i < 10 ; i++) {
                System.out.println("当前值是: "+i);
            }
        });
        executorService.shutdown();
    }

}
