package com.sum.note.java_thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sdl on 2019/4/14.
 */
public class ProxyTest {

    public interface PI {
        void print();
    }

    public static class ACompany implements PI {
        @Override
        public void print() {
            System.out.println("A do work");
        }
    }

    public static class BCompany implements PI {
        @Override
        public void print() {
            System.out.println("B do work");
        }
    }

    public static class ProxyPI implements PI {

        PI pi;

        ProxyPI(PI pi) {
            this.pi = pi;
        }

        @Override
        public void print() {
            pi.print();
            System.out.println("ProxyPI do work");
        }
    }

    public static class ProxyDynamic implements InvocationHandler {


        Object pi;

        ProxyDynamic(PI pi) {
            this.pi = pi;
        }

        Object getProxy() {
            return Proxy.newProxyInstance(pi.getClass().getClassLoader(),
                    pi.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //这里需要执行目标对象实力的的方法!!不是proxy对象
            Object invoke = method.invoke(pi, args);
            System.out.println("ProxyDynamic do work！！！！"+method.getName());
            return invoke;
        }
    }


    public static void main(String[] args) {

        //静态代理
//        PI proxyPI = new ProxyPI(new BCompany());
//        proxyPI.print();

        //动态代理
        ProxyDynamic dynamic = new ProxyDynamic(new ACompany());
        PI proxy = (PI) dynamic.getProxy();
        proxy.print();
        System.out.println("ProxyDynamic new->>>" + proxy);
    }

}
