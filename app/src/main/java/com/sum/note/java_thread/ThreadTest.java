package com.sum.note.java_thread;

/**
 * Created by sdl on 2019/4/14.
 */
public class ThreadTest {

    public static class InterruptThread extends Thread {

        @Override
        public void run() {
            System.out.println("thread start " + isInterrupted());
            while (!isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println("sleep one time " + isInterrupted());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //interrupt 只是通知需要结束线程，并非将线程停止
                    //需要手动再次打断一次
                    interrupt();
                }
            }
            System.out.println("thread finis " + isInterrupted());
        }
    }

    public static void main(String[] args) {

        InterruptThread thread = new InterruptThread();
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();


    }


}
