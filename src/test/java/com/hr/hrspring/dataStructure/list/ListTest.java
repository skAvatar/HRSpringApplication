package com.hr.hrspring.dataStructure.list;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ListTest {


    @Test
    void findMaximumIndexProduct(){

        List<Integer> arr = List.of(5, 4, 3, 4, 5);
        int max = 0;
        for(int index = 0; index < arr.size(); index++){
            System.out.println("Iteration > " + (index + 1) );
            int leftAndRight = leftAndRight(arr, index );
            System.out.println("leftAndRight > " + leftAndRight );


        }

        System.out.println("max > " + max);
    }

    int leftAndRight (List<Integer> arr, int i){
        System.out.println("Left -----------------------------------------");
        int left = 0;
/*        for(int j = i; j >= 0; j--){
            if((i > j) &&
                    (arr.get(j) > arr.get(i))){
                System.out.println(" j > " + j);
                return j;
            }
            //System.out.println(arr.get(i));
        }*/












        
        return 0;
    }

/*    int right (List<Integer> arr, int i){
        System.out.println("Right ----------------------------------------");

        for(int k = i; k <= arr.size() -1; k++){
            if((k > i) &&
                    (arr.get(k) > arr.get(i))){
                System.out.println(" k > " + k);
                return k;
            }
        }
        return 0;
    }*/
}
