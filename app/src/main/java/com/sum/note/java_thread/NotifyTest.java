package com.sum.note.java_thread;

/**
 * Created by sdl on 2019/4/14.
 */
public class NotifyTest {

    private int km = 0;


    /**
     * 通知方：
     * 1.获取对象锁
     * 2.修改条件
     * 3.sync(对象){
     * notifyAll()/notify()
     * }
     */


    public synchronized void addKm() {
        km = 101;
        notifyAll();//notify 之后通知一个线程
    }


    /**
     * 等待方：
     * 1.获取对象锁
     * 2.判断条件
     * 3.while(对象条件){
     * wait()
     * }
     * 4.执行业务代码
     */

    public synchronized void doWork() {
        while (km < 100) {
            try {
                System.out.println("thread wait start" + Thread.currentThread().getName());
                wait();//等待后，后续的代码需要notify来唤醒后再去执行
                System.out.println("thread wait " + Thread.currentThread().getName() + " is be notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread  do work " + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        final NotifyTest test = new NotifyTest();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.doWork();
                }
            }).start();
        }

        Thread.sleep(2000);
        test.addKm();

    }

}
