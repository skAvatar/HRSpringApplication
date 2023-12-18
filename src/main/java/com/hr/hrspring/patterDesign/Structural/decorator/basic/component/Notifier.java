package com.hr.hrspring.patterDesign.Structural.decorator.basic.component;

import com.hr.hrspring.patterDesign.Structural.decorator.basic.interf.INotifier;
import com.hr.hrspring.services.DatabaseService;
import lombok.Data;

@Data
public class Notifier implements INotifier {

    private final String userName;
    private final DatabaseService databaseService;

    public Notifier(String userName){
        this.userName = userName;
        databaseService = new DatabaseService();
    }

    @Override
    public void send (String msg){
        String mail = databaseService.getMailFromUserName(userName);
        System.out.println("Sending " + msg + " by Mail to " + mail);
    }

}
