package com.hr.hrspring.Intro;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

@SpringBootTest
public class HRAlgorithms {

    @Test
    // https://www.hackerrank.com/challenges/gridland-metro/problem?isFullScreen=true
    public void gridLandMetro() {

        List<List<Integer>> track = new ArrayList<>();
        int i, jOne, jTwo, jMin = Integer.MAX_VALUE, jMax = 0, countOnes = 0;

/*       int n = 4, m = 4, k = 3; // result 9
        List<Integer> listOne = Arrays.asList(2, 2, 3);
        List<Integer> listTwo = Arrays.asList(3, 1, 4);
        List<Integer> listThee = Arrays.asList(4, 4, 4);*/
/*      0000
        0110 (3 - 2) + 1
        1111 (4 - 1) + 1
        0001 (4 - 4) + 1
        */

/*        int n = 2, m = 9, k = 3; // result 12
        List<Integer> listOne = Arrays.asList(2, 1, 5);
        List<Integer> listTwo = Arrays.asList(2, 2, 4);
        List<Integer> listThee = Arrays.asList(2, 8, 8);*/

/*         000000000
         111100001 (5 -1) = 4 + (4-2) 2 + (8-8) 0 */

/*       int n = 1, m = 5, k = 3; // result 0
        List<Integer> listOne = Arrays.asList(1, 1, 2);
        List<Integer> listTwo = Arrays.asList(1, 2, 4);
        List<Integer> listThee = Arrays.asList(1, 3, 5);*/

/*        00000
        11111 (2 -1 ) = 1 +1 , (4 - 2) =2 +1, (5 -3) = 2 +1*/

        int n = 3, m = 7, k = 4; // result 11
        List<Integer> listOne = Arrays.asList(1, 1, 3);
        List<Integer> listTwo = Arrays.asList(2, 2, 2);
        List<Integer> listThee = Arrays.asList(3, 1, 6);
        List<Integer> listFour = Arrays.asList(3, 6, 6);

/*        00000
        11111 (2 -1 ) = 1 +1 , (4 - 2) =2 +1, (5 -3) = 2 +1*/

        track.add(listOne);
        track.add(listTwo);
        track.add(listThee);
        track.add(listFour);



        for (List<Integer> actualTrack : track) {
            jOne = actualTrack.get(1);
            jTwo = actualTrack.get(2);

            if (jOne < jMin) {
                jMin = jOne;
            }
            if (jTwo > jMax) {
                jMax = jTwo;
            }
            countOnes = validateRange(jOne, jTwo, jMin, jMax, countOnes);
        }
        System.out.println("result >" + ((n * m) - countOnes));
    }

    private int validateRange(int jOne, int jTwo, int jMin, int jMax, int countOnes) {

        if (jOne == jTwo && jOne!=jMax) {
            return countOnes += 1;
        }
        if (jOne > jMax ){
            countOnes += (jTwo - jOne) + 1;
            return countOnes;
        }
        if (jTwo <= jMin){
            countOnes += (jTwo - jOne) + 1;
            return countOnes;
        }
        if (jOne <= jMin && jTwo <= jMax) {

            countOnes += (jTwo - jOne) + 1;
            return countOnes;
        } else {

            if(jOne > jMin && jTwo < jMax){
                return countOnes;
            }else if (jOne == jTwo){
                return countOnes+=1;
            }

            int repeatOnes = 0;
            if(jOne > jMin && jOne !=jMax){
                repeatOnes = jOne - jMin;
                countOnes += ((jTwo - jOne) + 1) - repeatOnes;
                return countOnes;
            }

            return countOnes;
        }
    }

    @Test
    // https://www.hackerrank.com/challenges/phone-book/problem?isFullScreen=true&utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
    public void javaMap() {

        String[] input = {"3", "uncle sam", "99912222", "tom", "11122222", "harry", "12299933", "uncle sam", "uncle tom", "harry"};



    }

    @Test
    // https://www.hackerrank.com/challenges/phone-book/problem?isFullScreen=true&utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
    public void electronicShop() {
        /*
         * Write your code here.
         */
        Integer[] keyboards = { 3 , 1};
        Integer[] drives = { 5 , 2, 8};
        Integer b = 10;

        Arrays.sort(keyboards);
        Arrays.sort(drives);

        Integer temp = 0;
        Integer total = 0;

        if ((keyboards[0] + drives[0]) > b ) {
            System.out.println("-1");
        }

        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                if ((keyboards[i] + drives[j]) <= b) {
                    temp = keyboards[i] + drives[j];
                    System.out.println("temp > " + temp);
                }
            }
            if (temp > total) {
                total = temp;
                System.out.println("total > " + total);
            }
        }

    }

    @Test
    public void leftRotation() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5); int d = 4;
/*        List<Integer> a = Arrays.asList(41, 73, 89, 7, 10, 1, 59, 58,
                84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51); int d = 10;*/
        List<Integer> result = new ArrayList<>();
        int  maxSize = a.size();
        int start = a.lastIndexOf(a.get(d));

        for (int i = 0; i < maxSize ; i++) {
            result.add(a.get(start));
            start++;
            if(start == maxSize ){
                start = 0;
            }

            System.out.println("for >> " + result);
        }
        System.out.println(result);
        Assertions.assertEquals(  Arrays.asList(5, 1, 2, 3, 4), result);
        //Assertions.assertEquals(  Arrays.asList(77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77), result);

    }


/*    if(i == a.size()-1){
        result.set(0, a.get(a.size()-1));
    }else {

        result.set(Math.abs(Math.abs(i - d) - a.size()) - 1, a.get(i));
    }else {
        result.set(Math.abs(Math.abs(i - d) - a.size()), a.get(i));
    }
}
            System.out.println(result);*/





}
