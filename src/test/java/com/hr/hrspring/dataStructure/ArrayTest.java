package com.hr.hrspring.dataStructure;

import org.junit.jupiter.api.Test;

public class ArrayTest {

    @Test
    void printfN(){

        int n = 5;
        int[] a = new int[n];

        for(int i= 0; i < n; i++){
            a[i] = (i+1)* 10;
            //System.out.println(a[i]);
        }


    }
}
