package com.hr.hrspring.poo;

import com.hr.hrspring.poo.dto.MyBook;
import com.hr.hrspring.poo.dto.Person;
import com.hr.hrspring.poo.dto.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class POOTest {

    @Test
    void inheritanceTest(){

        int[] testCores = {100, 100,100};

        Student student = new Student("Heraldo", "Memelli", 8135627, testCores);
        Student.methodTest();
        Person.methodTest();
        Assertions.assertEquals('O', student.calculate());

    }

    @Test
    void abstractTest(){

        MyBook myBook = new MyBook("The Alchemist", "Paulo Coelho", 248);
        myBook.display();

    }



}
