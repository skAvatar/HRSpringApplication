package com.hr.hrspring.dataStructure.enums;

import com.hr.hrspring.enums.Cities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EnumTest {

    @Test
    public void checkAllValues(){
        List<String> cities = new ArrayList<>();
        for(Cities cityActual: Cities.class.getEnumConstants()){
            System.out.println(cityActual.city);
            cities.add(cityActual.city);
        }

        Assertions.assertEquals(Cities.class.getEnumConstants().length,
                cities.size());
    }

}
