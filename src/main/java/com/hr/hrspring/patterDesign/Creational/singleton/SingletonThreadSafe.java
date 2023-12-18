package com.hr.hrspring.patterDesign.Creational.singleton;

import lombok.Getter;

@Getter
public class SingletonThreadSafe<T> {

    private static volatile SingletonThreadSafe singletonThreadSafe;

    private T data;
    private SingletonThreadSafe(){

    }

    public static synchronized SingletonThreadSafe getInstance(){
        if(singletonThreadSafe == null){
            singletonThreadSafe = new SingletonThreadSafe();
        }
        return singletonThreadSafe;
    }

    public void setData( T data) {
        this.data = data;
    }

}
