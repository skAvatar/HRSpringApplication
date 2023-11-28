package com.hr.hrspring.finalStatic;

import lombok.Data;


// Static
// Classes -> only on the case of singleton
@Data
public class Static {

    String name;
    int age;

    // Field -> Will be shared across all instances
    public static int numberOfClasses;

    public Static(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfClasses++;
    }

    // Method -> Can't use this or super
    public static int staticMethod(){
        return numberOfClasses + 10;
    }
}
