package com.hr.hrspring.dto;

import com.hr.hrspring.enums.Gender;
import lombok.Data;

@Data
public class Person {

    public final String name;
    public final Gender gender;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }


}
