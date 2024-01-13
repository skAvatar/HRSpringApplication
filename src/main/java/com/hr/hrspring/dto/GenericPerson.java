package com.hr.hrspring.dto;

import com.hr.hrspring.enums.Gender;
import lombok.Data;

@Data
public class GenericPerson {

    public final String name;
    public final Gender gender;

    public GenericPerson(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }


}
