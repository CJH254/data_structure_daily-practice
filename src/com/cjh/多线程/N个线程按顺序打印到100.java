package com.cjh.多线程;

/**
 * @author 陈哈哈
 * @date 2022年12月28日 18:18
 * @description
 * @Data
 */
public class N个线程按顺序打印到100 extends Thread {
    static int n = 6; // 线程数量
    static volatile int cnt = 0; // 计数，到100结束

    private int id;  // 线程编号

    public N个线程按顺序打印到100(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (cnt <= 100) {
            synchronized (N个线程按顺序打印到100.class) {
                if (cnt % n == id) {
                    cnt++;
                    if (cnt > 100) {
                        break;
                    }
                    System.out.println("thread_" + id + " cnt:" + cnt);
                    N个线程按顺序打印到100.class.notify();
                    try {
                        N个线程按顺序打印到100.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            new N个线程按顺序打印到100(i).start();
        }
    }
}
