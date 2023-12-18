package com.hr.hrspring.patterDesign.Structural.facade.basic;

import lombok.Data;

@Data

public class User {

    private Long id;
    private double amount;
    private double balance = 1000;

    public User(){

    }
    public User(Long id){
        this.id = id;
    }


}
