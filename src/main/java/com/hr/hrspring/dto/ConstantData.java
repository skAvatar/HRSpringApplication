package com.hr.hrspring.dto;

import com.hr.hrspring.enums.Gender;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ConstantData {

    public static List<Person> people = Arrays.asList(
        new Person("John", Gender.MALE),
        new Person("Maria", Gender.FEMALE),
        new Person("Aisha", Gender.FEMALE),
        new Person("Alex", Gender.MALE),
        new Person("Alice", Gender.FEMALE)
    );



}
