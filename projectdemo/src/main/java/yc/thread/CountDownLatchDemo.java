package yc.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    private static Random random = new Random();

    private static ExecutorService executorService = ThreadPoolExecutorUtil.getThreadPoolExecutor(4,20,
            2000L,TimeUnit.SECONDS,200,"Hello World." + random.nextInt());

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {

        CountDownLatchDemo demo = new CountDownLatchDemo();
        try {
            demo.countDownLantchOneToFive();
            demo.countDownLantchSixToTen();
            executorService.shutdown();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     *
     */
    private void countDownLantch() throws Exception {

        // 计数器
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for(int i = 1; i < 5 ; i++) {
           new CountDownThread(i).start();
            countDownLatch.countDown();
        }
        countDownLatch.await();

        System.out.println("jie shu .");

    }

    class CountDownThread extends Thread {

        private int number;

        public CountDownThread(int number) {
            super();
            this.number = number;
        }
        @Override
        public void start() {
            Thread.currentThread().setName("Happy ");
            System.out.println(Thread.currentThread().getName()+ "I am " + number);
        }
    }

    public void countDownLantchOneToFive() throws Exception {
        executorService.execute(()->{

            System.out.println("线程"+Thread.currentThread().getName()+"开始执行...");
            System.out.println("1 2 3 4 5...");
        });

        countDownLatch.countDown();
    }

    public void countDownLantchSixToTen() throws Exception {
        countDownLatch.await();
        executorService.execute(()->{

            System.out.println("线程"+Thread.currentThread().getName()+"开始执行...");
            System.out.println("6 7 8 9 10...");
        });
        //executorService.shutdown();
    }

}
