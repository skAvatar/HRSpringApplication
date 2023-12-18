package com.hr.hrspring.patterDesign.Structural.decorator.basic.concrete;

import com.hr.hrspring.patterDesign.Structural.decorator.basic.base.BaseNotifierDecorator;
import com.hr.hrspring.patterDesign.Structural.decorator.basic.interf.INotifier;

public class FacebookDecorator extends BaseNotifierDecorator {


    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg){
        super.send(msg);
        String fbName = databaseService.getFBNameFromUserName(getUserName());
        System.out.println("Sending " + msg + " on Facebook to " + fbName);
    }
}
