package com.sum.note.java_thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sdl on 2019/4/14.
 */
public class ThreadPoolTest {

    private static class CustomThreadPool {

        //可以不指定大小
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        //必须指定对列大小
        private BlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

    }


}
