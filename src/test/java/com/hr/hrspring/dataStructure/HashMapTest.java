package com.hr.hrspring.dataStructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@SpringBootTest
public class HashMapTest {

    @Test
    public void javaHashMap(){

        List<String> book = Arrays.asList("uncle sam", "99912222", "tom","11122222", "harry", "12299933");

        List<String> searchNames = Arrays.asList("uncle sam", " uncle tom", "harry");
        HashMap<String, String> phoneBook = new HashMap<>();

        int index = 0;
        for(String actualString: book){
            if(actualString.matches("^[0-9]*$")){
                phoneBook.put(book.get(index), book.get(index + 1));
                index+= 2;
            }
        }

        for(String actualName: searchNames){
            if(phoneBook.get(actualName) == null){
                System.out.println("Not Found");
            }else{
                System.out.println(actualName + "="+ phoneBook.get(actualName));
            }
        }

        Assertions.assertEquals("99912222", phoneBook.get("uncle sam"));

    }
}
