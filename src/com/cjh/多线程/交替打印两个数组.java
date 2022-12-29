package com.cjh.多线程;

/**
 * @author 陈哈哈
 * @date 2022年12月28日 22:07
 * @description
 * @Data
 */
public class 交替打印两个数组 {
    int[] arr1 = new int[]{1, 3, 5, 7, 9};
    int[] arr2 = new int[]{2, 4, 6, 8, 10};

    boolean flag;

    public synchronized void print1() {
        for (int i = 0; i < arr1.length; i++) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            flag = !flag;
            System.out.println(arr1[i]);
            notifyAll();
        }
    }

    public synchronized void print2() {
        for (int i = 0; i < arr2.length; i++) {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            flag = !flag;
            System.out.println(arr2[i]);
            notifyAll();
        }
    }

    public static void main(String[] args) {

        交替打印两个数组 twoArr = new 交替打印两个数组();

        new Thread(new Runnable() {
            @Override
            public void run() {
                twoArr.print1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                twoArr.print2();
            }
        }).start();
    }
}
