package com.cjh.多线程;

/**
 * @author 陈哈哈
 * @date 2022年12月28日 22:51
 * @description
 * @Data
 */
public class 生产者消费者 {

    private int count = 0;
    private static final int FULL = 10;
    private final static String LOCK = "lock";

    public static void main(String[] args) {
        生产者消费者 生产者消费者 = new 生产者消费者();
        for (int i = 1; i <= 5; i++) {
            new Thread(生产者消费者.new Producer(), "生产者_" + i).start();
            new Thread(生产者消费者.new Consumer(), "消费者_" + i).start();
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < FULL; i++) {
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 总共有 " + ++count + " 个资源");
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < FULL; i++) {
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 总共有 " + --count + " 个资源");
                    LOCK.notifyAll();
                }
            }
        }
    }
}
