package yc.handler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者 消费者
 * 使用可重入锁实现
 */
public class ProducerAndConsumerDemo {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private Queue<String> queue = new LinkedList<String>();

    class Produce extends Thread {

        //生产者
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    int length = queue.size();
                    int MAX_NUMBER = 10;
                    if (length >= MAX_NUMBER) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        queue.add("商品");
                        System.out.println("当前增加了一个商品");
                        condition.signalAll();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer extends Thread{
        //消费者
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    int length = queue.size();
                    if (length > 0) {
                        queue.poll();
                        System.out.println("当前消费了一个商品");
                        condition.signalAll();
                    } else {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("当前无商品消费。。");
                    }
                }
                finally {
                    lock.unlock();;
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerDemo demo = new ProducerAndConsumerDemo();
        Produce produce = demo.new Produce();
        produce.start();
        Consumer consumer = demo.new Consumer();
        consumer.start();
    }


}
