package com.hr.hrspring.Intro.finalStatic;

import com.hr.hrspring.finalStatic.Final;
import com.hr.hrspring.finalStatic.Static;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinalStaticTest {

    @Test
    void finalClassTest(){
        Final newFinal = new Final();
        newFinal.setName("Final Test");
        Assertions.assertEquals("Final Test", newFinal.getName());
    }

    @Test
    void finalMethodTest(){
        Final newFinal = new Final();
        Long methodResult = newFinal.methodFinal(10 , 10);
        Assertions.assertEquals(20, methodResult);
    }

    @Test
    void finalVariableTest(){
        final Final newFinal = new Final();
        // V -> reference -> the instance can not be reassigned
        //newFinal = new Final();
    }

    @Test
    void staticVarTest(){

        Static newStatic1 = new Static("name1", 10);
        Static newStatic2 = new Static("name2", 20);
        Static newStatic3 = new Static("name3", 30);
        Static newStatic4 = new Static("name4", 40);

        Assertions.assertEquals(4, Static.numberOfClasses);

        // Property is for the class
        Static.numberOfClasses++;
        Assertions.assertEquals(5, Static.numberOfClasses);

    }

    @Test
    void staticMethod(){
        Static newStatic1 = new Static("name1", 10);
        Static newStatic2 = new Static("name2", 20);

        // Can be done but must not
        newStatic1.staticMethod();

        // Calls direct from class no the instance
        Assertions.assertEquals(12, Static.staticMethod());

    }



}
