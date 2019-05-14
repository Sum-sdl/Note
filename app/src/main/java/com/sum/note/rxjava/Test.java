package com.sum.note.rxjava;


import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by sdl on 2019/4/21.
 */
public class Test {

    public static void main(String[] args) {
//        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//
//                emitter.onNext("施德磊是坏蛋");
//                emitter.onNext("施德磊是坏蛋1");
//                emitter.onNext("施德磊是坏蛋2");
//                //emitter.onComplete();
//                //emitter.onComplete();
//                //emitter.onError(new Throwable());
////                emitter.onError(new Throwable());
//                emitter.onNext("施德磊是坏蛋3");
//            }
//        }).map(new Function<String, String>() {
//            @Override
//            public String apply(String s) throws Exception {
//                if (s.contains("2")) {
//                    throw new NullPointerException();
//                }
//                return s + " map1111->";
//            }
//
//        }).map(new Function<String, String>() {
//            @Override
//            public String apply(String s) throws Exception {
//
//                return s + " map22222";
//            }
//
//        });
//
//        Observer observer = new Observer() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                System.out.println("onSubscribe");
//            }
//
//            @Override
//            public void onNext(Object o) {
//                System.out.println("onNext:" + o);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.out.println("onError:" + e);
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("onComplete");
//            }
//        };
//
//        observable.subscribe(observer);

        Observer observer1 = new Observer() {
            @Override
            void refresh(String msg) {
                System.out.println("用户一收到消息:" + msg);
            }
        };

        Observer observer2 = new Observer() {
            @Override
            void refresh(String msg) {
                System.out.println("用户二收到消息:" + msg);
            }
        };

        Observable observableUser = new Observable(new ITask() {
            @Override
            public void pushMessage(String msg) {

            }
        });
        observableUser.add(observer1);
        observableUser.add(observer2);
//        observableUser.pushMessage("您有一条新消息");

    }

}
