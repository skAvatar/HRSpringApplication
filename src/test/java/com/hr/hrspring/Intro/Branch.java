package com.hr.hrspring.Intro;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class Branch {

    @Test
    public void transformation() {

        String stringA = "1, 2 ,3"; // [1,2,3]
        String stringB = "2-6"; //[2, 3, 4, 5, 6]
        String stringC = "1, 3-5, 9"; // [1, 3, 4, 5, 9]
        List<Integer> result = new ArrayList<>();

        for(String actualString: stringC.split(",") ){
            if(actualString.contains("-")){
                String[] rangeNumber = actualString.split("-");
                int rangeL = Integer.parseInt(rangeNumber[0].trim());
                int rangeR = Integer.parseInt(rangeNumber[1].trim());
                for(int index = rangeL; index <= rangeR; index++){
                    result.add(index);
                }
            }else{
                result.add(Integer.valueOf(actualString.trim()));
            }
        }
        System.out.println("result > " + result);
    }





}
