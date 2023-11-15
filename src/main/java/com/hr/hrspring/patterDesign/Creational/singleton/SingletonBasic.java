package com.hr.hrspring.patterDesign.Creational.singleton;

public class SingletonBasic<T> {

    private static SingletonBasic singletonBasic;

    private T data;
    private SingletonBasic(){

    }

    public static SingletonBasic getInstance(){
        if(singletonBasic == null){
            singletonBasic = new SingletonBasic();
        }
        return singletonBasic;
    }

    public T getData() {
        return data;
    }
    public void setData( T data) {
        this.data = data;
    }

}
