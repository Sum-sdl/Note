package com.sum.note.classloader;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

/**
 * Created by sdl on 2019/4/18.
 */
public class LoaderTest {

    public static void test() {
        //        ClassLoader
//        System.arraycopy(, , , , );

        PathClassLoader pathClassLoader = new PathClassLoader("xx.dex", ClassLoader.getSystemClassLoader());

        DexClassLoader dexClassLoader = new DexClassLoader("xx.dex", "odex", "", LoaderTest.class.getClassLoader());

    }

}
