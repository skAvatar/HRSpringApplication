package com.hr.hrspring.services;

import com.hr.hrspring.patterDesign.Structural.facade.basic.User;

public class DatabaseService {

    public String getMailFromUserName(String userName){
        return userName + "@mail";
    }

    public String getFBNameFromUserName(String userName){
        return userName + "@Facebook";
    }

    public String getPhoneNbrFromUserName(String userName){
        return userName + "@WhatsApp";
    }
    public User getUser (Long id){
        return new User(10L);
    }

}