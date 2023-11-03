package com.hr.hrspring.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class StreamTest {

    @Test
    void filterList() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int maxValue = numbers.stream()
                .mapToInt(x -> x)
                .max().getAsInt();

        Assertions.assertEquals(6,maxValue);

    }
}
