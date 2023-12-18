package com.hr.hrspring.dto;

import lombok.Data;

@Data
public abstract class AbstractPerson {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    public AbstractPerson(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }
    public static void methodTest(){
        System.out.println("print on person");
    }

}
