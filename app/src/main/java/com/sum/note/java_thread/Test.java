package com.sum.note.java_thread;

/**
 * Created by sdl on 2019/4/14.
 */
public class Test {

    public static class Ohter {
        int o_a = 100;
    }

    private int count = 10;

    private int add(int b, Ohter ohter) {
        int a = 1;
        int c = a + b + count + ohter.o_a;
        return c;
    }
}
