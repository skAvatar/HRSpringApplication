package com.hr.hrspring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Recursion {

    @Test
    void factorialCore(){

        int n = 3;

        n = Recursion.Factorial(n);
        System.out.println(n);
    }

    private static int Factorial(int n) {
        if(n <= 1){
            return 1;
        }
        return n * Factorial(n-1);

    }



}
