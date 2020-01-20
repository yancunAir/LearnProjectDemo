package yc.thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumerDemo2 {


    /**
     * lock + condition 实现生产者和消费者
     */

    private Queue<Integer> queue = new LinkedList<Integer>();

    private final Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private final int MAX_SIZE = 10;


    class Producer extends Thread {

        public Producer() {

        }

        @Override
        public void run() {

            while (true) {
                lock.lock();

                try {
                    while (queue.size() == MAX_SIZE)

                        System.out.println("队列已满。。。。");

                    try {
                        condition.await();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    queue.add(1);
                    System.out.println("生产了一个值，当前队列size为"+queue.size());
                    condition.signal();
                    try {
                        Thread.sleep(1000L);
                    }
                    catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                } finally {
                    lock.unlock();
                }


            }
        }
    }


    class Consumer extends Thread {

        public Consumer() {
        }

        @Override
        public void run() {

            while (true) {

                lock.lock();
                try {
                    while (queue.size() == 0) {

                        System.out.println("队列为空，无须消费。。。");
                        try {
                            condition.await();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    queue.poll();
                    System.out.println("消费了一个值。。。");
                    condition.signal();
                    try {
                        Thread.sleep(1000L);
                    }
                    catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                } finally {
                    lock.unlock();
                }

            }


        }

    }


    public static void main(String[] args) {

        ProducerAndConsumerDemo2 demo = new ProducerAndConsumerDemo2();
        Producer producer = demo.new Producer();
        Consumer consumer = demo.new Consumer();
        producer.start();
        consumer.start();

    }
}
