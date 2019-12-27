package yc.leetcode;

import java.util.concurrent.CountDownLatch;

public class Problem1114 {

    public static void main(String[] args) {
        Foo  foo = new Problem1114.Foo();
        Thread t1 = new Thread(()->{
            try {
                foo.first(()->{
                    System.out.println("one");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1");

        Thread t2 = new Thread(()-> {
            try {
                foo.second(() -> {
                    System.out.println("two");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2");

        Thread t3 = new Thread(()-> {
            try {
                foo.third(() -> {
                    System.out.println("three");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程3");

        t2.start();
        t3.start();
        t1.start();

    }


    private static class Foo {

        private CountDownLatch countDownLatch1;
        private CountDownLatch countDownLatch2;

        public Foo() {
            countDownLatch1 = new CountDownLatch(1);
            countDownLatch2 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatch1.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            countDownLatch1.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            countDownLatch2.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            countDownLatch2.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
