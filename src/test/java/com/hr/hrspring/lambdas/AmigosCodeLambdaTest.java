package com.hr.hrspring.lambdas;

import com.hr.hrspring.dto.GenericPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.hr.hrspring.dto.MockData.people;
import static com.hr.hrspring.enums.Gender.FEMALE;

@SpringBootTest
public class AmigosCodeLambdaTest {

    @Test
    void filterFemale() {
        // Imperative
        List<GenericPerson> females = new ArrayList<>();
        for(GenericPerson peopleActual: people){
            if(FEMALE.equals(peopleActual.getGender())){
                females.add(peopleActual);
            }
        }
        Assertions.assertEquals(3, females.size());

        // Declarative
        people.stream()
                .filter(genericPerson -> FEMALE.equals(genericPerson.getGender()))
                .toList()
                .forEach(System.out::println);


        // Option 2



    }

}


