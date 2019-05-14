package com.sum.note.rxjava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdl on 2019/4/25.
 */
public class Observable {
    private List<Observer> list = new ArrayList<>();
    ITask task;

    public Observable(ITask iTask){
        task = iTask;
    }

    public void add(Observer observer){
        task.pushMessage("1111");
        list.add(observer);
    }

    public void pushMessage(String msg){
        for (Observer observer:list){
            observer.refresh(msg);
        }
    }
}
