package com.hr.hrspring;

import ch.qos.logback.core.net.server.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

@SpringBootTest
public class HRImplementationMedium {


    /*
    Read List
    Scanner in = new Scanner(System.in);
    int numSentences = Integer.parseInt(in.nextLine());
    */

    @Test
    public void climbingTheLeaderboard2() {
        /*
        List<Integer> ranked = Arrays.asList(100, 90, 90, 80, 75, 60);
        List<Integer> ranked = Arrays.asList(100, 90, 80, 75, 60);
        List<Integer> player = Arrays.asList(50, 65, 77, 90, 102);
        */
        // expected 6 5 4 2 1

        //List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        List<Integer> ranked = Arrays.asList(100, 50, 40, 20, 10);
        List<Integer> player = Arrays.asList(5, 25, 50, 120);
        // expected 6 4 2 1


        /*
        List<Integer> ranked = Arrays.asList(997, 988, 981, 966, 957, 937, 933, 930, 929, 928, 927, 926, 922, 920, 916, 915, 903, 896, 887, 874, 872, 866, 863, 863, 860, 859, 858, 857, 857, 847, 847, 842, 830, 819, 815, 809, 803, 797, 796, 794, 794, 789, 785, 783, 778, 772, 765, 765, 764, 757, 755, 751, 744, 740, 737, 733, 730, 730, 724, 716, 710, 709, 691, 690, 684, 677, 676, 653, 652, 650, 625, 620, 619, 602, 587, 587, 585, 583, 571, 568, 568, 556, 552, 546, 541, 540, 538, 531, 530, 529, 527, 506, 504, 501, 498, 493, 493, 492, 489, 482, 475, 468, 457, 452, 445, 442, 441, 438, 435, 435, 433, 430, 429, 427, 422, 422, 414, 408, 404, 400, 396, 394, 387, 384, 380, 379, 374, 371, 369, 369, 369, 368, 366, 365, 363, 354, 351, 341, 337, 336, 328, 325, 318, 316, 314, 307, 306, 302, 287, 282, 281, 277, 276, 271, 246, 238, 236, 230, 229, 229, 228, 227, 220, 212, 199, 194, 179, 173, 171, 168, 150, 144, 136, 125, 125, 124, 122, 118, 98, 98, 95, 92, 88, 85, 70, 68, 61, 60, 59, 44, 43, 35, 32, 30, 28, 23, 20, 13, 12, 12);
        List<Integer> player = Arrays.asList(83, 129, 140, 184, 198, 300, 312, 325, 341, 344, 349, 356, 370, 405, 423, 444, 465, 471, 491, 500, 506, 508, 539, 543, 569, 591, 607, 612, 614, 623, 645, 670, 689, 726, 744, 747, 764, 773, 777, 787, 805, 811, 819, 829, 841, 905, 918, 918, 955, 997);
        */

        var distinctRanked = ranked.stream().distinct().collect(Collectors.toList()).toArray();
        // Write your code here

        var output = new ArrayList<Integer>();

        var prevResult = distinctRanked.length - 1;
        for (Integer newPlayerScore : player) {
            var result = prevResult;
            for (int i1 = prevResult; i1 >= 0; i1--) {
                var rankedScore = (Integer) distinctRanked[i1];
                if (rankedScore <= newPlayerScore) result--;
                else break;
            }
            prevResult = result;
            output.add(result + 2);
        }
        System.out.println(output);
    }

    @Test
    public void gradingStudents() {
        List<Integer> grades = Arrays.asList(73, 67, 38, 33);
        int diffValue = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer actualGrade : grades) {
            int lastDigit = actualGrade % 10;
            if (lastDigit > 5) {
                diffValue = 10 - lastDigit;
            } else {
                diffValue = 5 - lastDigit;
            }
            if ((actualGrade + diffValue) >= 40) {
                int roundValue = 0;
                if (diffValue < 3) {
                    roundValue = actualGrade + diffValue;
                    result.add(roundValue);
                } else {
                    result.add(actualGrade);
                }
            } else {
                result.add(actualGrade);
            }
        }
        Assertions.assertEquals(Arrays.asList(75, 67, 40, 33), result);
    }

    @Test
    public void countApplesAndOranges() {

/*      int s = 7, t = 11, a = 5, b = 15;
        List<Integer> apples = Arrays.asList(-2, 2, 1);
        List<Integer> oranges = Arrays.asList(5, -6);
        List<Integer> fruit = apples;*/
        // expected 1 1

        int s = 7, t = 10, a = 4, b = 12;
        List<Integer> apples = Arrays.asList(2, 3, -4);
        List<Integer> oranges = Arrays.asList(3, -2, -4);
        List<Integer> fruit = apples;
        // expected 1 2
        boolean isOrange = false;
        for (int i = 1; i <= 2; i++) {
            if (i == 2) {
                fruit = oranges;
                isOrange = true;
            }
            System.out.println(calculateDistanceFruit(fruit, s, t, a, b, isOrange));
        }



    }

    private long calculateDistanceFruit(List<Integer> fruit, int s, int t, int a, int b, boolean isOrange) {
        long countFruit = 0;
        if (isOrange) {
            a = b;
        }
        int finalA = a;
        countFruit = fruit.stream().filter(f -> s <= (f + finalA) && (f + finalA) <= t).count();
       /* System.out.println("isOrange > " + isOrange);
        System.out.println("countFruit > " + countFruit);*/
        return countFruit;
    }

    @Test
    public void patternSyntaxChecker() {

        ArrayList<String> input = new ArrayList<>();
        input.add("([A-Z])(.+)");
        input.add("[AZ[a-z](a-z)");
        input.add("batcatpat(nat");

        for (String actualReg : input) {
            try {
                Pattern.compile(actualReg);
                System.out.println("Valid");
            } catch (PatternSyntaxException exception) {
                System.out.println("Invalid");
            }
        }
    }

    @Test
    public void ipAddress(){

        ArrayList<String> input = new ArrayList<>();
        input.add("000.12.12.034");
        input.add("121.234.12.12");
        input.add("01.01.01.01");
        input.add("00.12.123.123123.123");
        input.add("122.23");
        input.add("110.110.110.010");
        input.add("10.10.10.10");
        input.add("122.23");
        input.add("Hello.IP");

    int i =148;
        for(String IP: input){
            System.out.println("i > :" + i + " "+ IP.matches(MyRegex.pattern));
            i++;
        }

    }
    private static class MyRegex {
        private static final String pattern = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?)$";

    }
    @Test
    public void duplicateWord(){

        ArrayList<String> input = new ArrayList<>();
        input.add("Goodbye bye bye world world world");
        input.add("Sam went went to to to his business");
        input.add("Reya is is the the best player in eye eye game");
        input.add("in inthe");
        input.add("Hello hello Ab aB");

        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex);

        for (String actualString: input){
            Matcher m = p.matcher(actualString);
            if(m.find()){

                do{
                    actualString = actualString.replaceAll(m.group(), m.group(1));
                }while (p.matcher(actualString).find());

                System.out.println(actualString);
            }else {
                System.out.println(actualString);
            }
        }
    }

    @Test
    public void reverseString(){

        String name = "enrique marin";
        StringBuilder result = new StringBuilder();
        char[] nameChar = name.toCharArray();
        for(int i=name.length() - 1;i >= 0; i--){
            result.append(nameChar[i]);
        }
        //"niram euqirne"
        Assertions.assertEquals(result.toString(),"niram euqirne");

    }

    @Test
    void maximumOccurringCharacter() {

        String text = "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";
        HashMap<Character, Integer> mapL = new HashMap<>();
        int count = 0;
        char result = 0;
        for(int i =0;i< text.length();i++){
            char c = text.charAt(i);
            mapL.put(c, mapL.getOrDefault(c, 0) + 1);
            if (count < mapL.get(c)){
                result = c;
                count = mapL.get(c);
            }
        }




    }

    @Test
    void totalMoves() {

        List<Integer> arr1 = List.of(1234, 4321);
        List<Integer> arr2 = List.of(2345, 3214);

        int min  = Integer.MAX_VALUE;
        int number = 0;
        for(int i =0; i< arr1.size();i++){
            number = number + getDiff(arr1.get(i), arr2.get(i));
        }
        System.out.println(number);
    }

    static int getDiff(Integer value1, Integer value2){
        char[] stringV1 = value1.toString().toCharArray();
        char[] stringV2 = value2.toString().toCharArray();

        int diff = 0;
        for(int i =0; i< stringV1.length;i++){

            diff = diff + Math.abs(stringV1[i] - stringV2[i]);

        }

        return diff;
    }



}


