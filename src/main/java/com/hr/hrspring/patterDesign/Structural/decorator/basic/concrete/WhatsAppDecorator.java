package com.hr.hrspring.patterDesign.Structural.decorator.basic.concrete;

import com.hr.hrspring.patterDesign.Structural.decorator.basic.base.BaseNotifierDecorator;
import com.hr.hrspring.patterDesign.Structural.decorator.basic.interf.INotifier;

public class WhatsAppDecorator extends BaseNotifierDecorator {
    public WhatsAppDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg){
        super.send(msg);
        String phoneNbr = databaseService.getPhoneNbrFromUserName(getUserName());
        System.out.println("Sending " + msg + " by WhatsApp to " + phoneNbr);
    }
}
