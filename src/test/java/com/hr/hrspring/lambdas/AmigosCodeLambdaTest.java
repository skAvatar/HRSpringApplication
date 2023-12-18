package com.hr.hrspring.lambdas;

import com.hr.hrspring.dto.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.hr.hrspring.dto.ConstantData.people;
import static com.hr.hrspring.enums.Gender.FEMALE;

@SpringBootTest
public class AmigosCodeLambdaTest {

    @Test
    void filterFemale() {
        // Imperative
        List<Person> females = new ArrayList<>();
        for(Person peopleActual: people){
            if(FEMALE.equals(peopleActual.getGender())){
                females.add(peopleActual);
            }
        }
        Assertions.assertEquals(3, females.size());

        // Declarative
        people.stream()
                .filter(person -> FEMALE.equals(person.getGender()))
                .toList()
                .forEach(System.out::println);


        // Option 2



    }

}


