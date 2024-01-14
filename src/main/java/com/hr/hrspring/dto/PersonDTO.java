package com.hr.hrspring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PersonDTO {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final Integer age;

    public static PersonDTO map(Person person){
        return new PersonDTO(person.getId(), person.getFirstName(), person.getLastName(),
                person.getEmail(), person.getGender(), person.getAge());
    }

}
