package com.hr.hrspring.patterDesign.Structural.decorator.basic;

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

}
