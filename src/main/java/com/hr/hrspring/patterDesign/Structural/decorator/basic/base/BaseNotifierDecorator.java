package com.hr.hrspring.patterDesign.Structural.decorator.basic.base;

import com.hr.hrspring.patterDesign.Structural.decorator.basic.DatabaseService;
import com.hr.hrspring.patterDesign.Structural.decorator.basic.interf.INotifier;

public abstract class BaseNotifierDecorator implements INotifier {

    private final INotifier wrapped;
    protected final DatabaseService databaseService;

    protected BaseNotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
        databaseService = new DatabaseService();
    }

    @Override
    public void send(String msg){
        wrapped.send(msg);
    }
    @Override
    public String getUserName(){
        return wrapped.getUserName();
    }



}
