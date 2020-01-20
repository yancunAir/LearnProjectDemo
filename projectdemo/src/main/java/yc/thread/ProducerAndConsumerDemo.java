package yc.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumerDemo {


    private final int MAX_SIZE = 10;

    private Queue<Integer> queue = new LinkedList<Integer>();


    class Producer extends Thread {

        private Producer() {
        }

        @Override
        public void run() {

            while (true) {
                synchronized (queue) {
                    if (queue.size() == MAX_SIZE) {
                        queue.notify();
                        System.out.println("生产者已满,请消费。。。。");
                        try {
                            queue.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                            ;
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    System.out.println("生产者新增一条数据,当前size为%d" + queue.size());
                }
            }
        }
    }


    class Consumer extends Thread {

        private Consumer() {
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {
                        queue.notify();
                        try {
                            queue.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("当前没有值需要消费。。。。");
                    }
                    queue.poll();
                    queue.notify();
                }
            }
        }
    }

}
