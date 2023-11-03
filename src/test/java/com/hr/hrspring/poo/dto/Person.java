package com.hr.hrspring.poo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    // Constructor
    public Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }
    public static void methodTest(){
        System.out.println("print on person");
    }

}
