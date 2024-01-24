package com.hr.hrspring.dto;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.hr.hrspring.enums.Gender;
import jakarta.annotation.Resource;
import lombok.Data;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class MockData {

    public static List<GenericPerson> genericPeople = Arrays.asList(
        new GenericPerson("John", Gender.MALE),
        new GenericPerson("Maria", Gender.FEMALE),
        new GenericPerson("Aisha", Gender.FEMALE),
        new GenericPerson("Alex", Gender.MALE),
        new GenericPerson("Alice", Gender.FEMALE)
    );

    public static List<GenericPerson> genericPeopleDub = Arrays.asList(
            new GenericPerson("John", Gender.MALE),
            new GenericPerson("John", Gender.MALE),
            new GenericPerson("John", Gender.MALE),
            new GenericPerson("John", Gender.MALE),
            new GenericPerson("Maria", Gender.FEMALE),
            new GenericPerson("Maria", Gender.FEMALE),
            new GenericPerson("Maria", Gender.FEMALE),
            new GenericPerson("Aisha", Gender.FEMALE),
            new GenericPerson("Aisha", Gender.FEMALE),
            new GenericPerson("Aisha", Gender.FEMALE),
            new GenericPerson("Alex", Gender.MALE),
            new GenericPerson("Alex", Gender.MALE),
            new GenericPerson("Alex", Gender.MALE),
            new GenericPerson("Alice", Gender.FEMALE)
    );

    public static List<ArrayList<String>> matrixNames = Lists.newArrayList(
            Lists.newArrayList("Miriam", "Alex", "Ismail"),
            Lists.newArrayList("John", "Alesha", "Andre"),
            Lists.newArrayList("Susy", "Ali")
    );

    public static List<Integer> numbers = List.of(1, 2, 3, 100, 23, 92, 99);

    public static List<Integer> numbersDup = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9);

    public static ImmutableList<Person> people(){
        try {
            InputStream inputStream = Resources.getResource("people.json").openStream();
            String json = IOUtils.toString(inputStream);
            Type listType = new TypeToken<ArrayList<Person>>(){}.getType();

            List<Person> people = new Gson().fromJson(json, listType);
            return ImmutableList.copyOf(people);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ImmutableList<UCar> uCars (){
        try {
            InputStream inputStream = Resources.getResource("cars.json").openStream();
            String json = IOUtils.toString(inputStream);
            Type listType = new TypeToken<ArrayList<UCar>>(){}.getType();

            List<UCar> cars = new Gson().fromJson(json, listType);
            return ImmutableList.copyOf(cars);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
