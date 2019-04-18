package com.sum.note.java_thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sdl on 2019/4/14.
 */
public class LockTest {

    /**
     * Condition Lock的中的数据
     *
     * */


    /**
     * readwriteLock 读写锁
     * <p>
     * 1.排他锁和非排他锁
     * 2.ReentrantReadWriteLock:读不锁，写锁
     */

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();//读线程
    private Lock writeLock = readWriteLock.writeLock();//写线程


    /**
     * Lock 显示锁
     * 1.读写锁
     * 2.标准锁
     * <p>
     * 公平锁：先申请先拿到(效率低点，上下文切换耗时：20000个时间单位 ，切换：线程挂起到执行耗时)
     * 非公平锁：可能后面的线程先拿到
     *
     */

    /**
     * 1.一定要在finally里面释放锁
     * 2.可重复进入锁：同一个线程，可以重复拿重复锁
     * 3.默认是非公平锁
     */
    private Lock lock = new ReentrantLock();//可重入锁

    //Condition是wait、notify的代码实现方案
    private Condition condition = lock.newCondition();

    public void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    private int count;

    public synchronized void add2() {
        count++;
        /**
         * synchronized 可重入锁
         * * */
        add2();
    }


    public static void main(String[] args) {

        final LockTest test = new LockTest();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.add();
                }
            }).start();
        }

    }

}
