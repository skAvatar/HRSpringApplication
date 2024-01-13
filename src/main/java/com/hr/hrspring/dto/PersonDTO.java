package com.hr.hrspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDTO {

    private final Integer id;
    private final String name;
    private final Integer age;

    public static PersonDTO map(Person person){
        return new PersonDTO(person.getId(), person.getName(), person.getAge());
    }

}
