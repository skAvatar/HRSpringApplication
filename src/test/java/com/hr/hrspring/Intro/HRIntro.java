package com.hr.hrspring.Intro;

import com.hr.hrspring.Intro.dto.Difference;
import com.hr.hrspring.Intro.interfaces.AdvancedArithmetic;
import com.hr.hrspring.Intro.interfaces.InterfacesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.BiFunction;

@SpringBootTest
public class HRIntro{

    // Input HR
    /*
    Scanner scan = new Scanner(System.in);
    String a = scan.next();
    String b = scan.next();
    scan.close(); */

    @Test
    void currencyFormat() {

        BigDecimal input = new BigDecimal(1234000);

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US: " + nf.format(input));

        nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String indianCoin = nf.format(input);
        indianCoin = "Rs." + indianCoin.substring(1);

        System.out.println("Indian: " + indianCoin);

        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String chinaCoin = nf.format(input);
        indianCoin = "￥" + indianCoin.substring(1);
        System.out.println("China: " + nf.format(input));

        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("Francia: " + nf.format(input));

    }

    @Test
    void solveOperator() {

        double mealCost = 10.75;
        int tipPercent = 17;
        int taxPercent = 5;

        double tip = (tipPercent * mealCost) / 100;
        double tax = (taxPercent * mealCost) / 100;

        int totalCost = (int) Math.round(mealCost + tax + tip);

        System.out.println(totalCost);

    }

    //https://www.hackerrank.com/challenges/30-review-loop/problem?isFullScreen=true
    @Test
    void letsReview() {
        List<String> input = List.of("Hacker", "Rank");

        for (String actualString : input) {
            splitString(actualString);
        }
    }

    private void splitString(String actualString) {

        char[] charString = actualString.toCharArray();
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < actualString.length(); i++) {
            if (i % 2 == 0) {
                even.append(charString[i]);
            } else {
                odd.append(charString[i]);
            }
        }

        System.out.println(even + " " + odd);

    }


    @Test
    void inverseNumbers() {
        List<Integer> input = List.of(1, 4, 3, 2);
        for (int i = input.size() - 1; i >= 0; i--) {
            System.out.print(input.get(i) + " ");

        }
    }

    // 30 Days Challenges
    // https://www.hackerrank.com/challenges/30-binary-numbers/problem?isFullScreen=true
    @Test // 10/30
    void binary() {
        int n = 15;

        int countOne = countOnes(n);
        Assertions.assertEquals(4,countOne);
    }

    private int countOnes(int n) {
        float rest = n;
        int maxOne = 0, consecutiveOne = 0;
        boolean isNumberBeforeOne = true;

        while (rest > 0) {
            if (rest % 2 == 0) {
                consecutiveOne = 0;
                isNumberBeforeOne = false;
            } else {
                if (isNumberBeforeOne) {
                    consecutiveOne++;
                    if (consecutiveOne > maxOne) {
                        maxOne = consecutiveOne;
                    }
                }
                isNumberBeforeOne = true;
            }
            rest = Math.floorDiv((int) rest, 2);
        }
        return maxOne;
    }

    //https://www.hackerrank.com/challenges/30-2d-arrays/problem
    @Test // 11/30
    void hourglass() {

        List<Integer> input1 = List.of(1, 1, 1, 0, 0, 0);
        List<Integer> input2 = List.of(0, 1, 0, 0, 0, 0);
        List<Integer> input3 = List.of(1, 1, 1, 0, 0, 0);
        List<Integer> input4 = List.of(0, 0, 2, 4, 4, 0);
        List<Integer> input5 = List.of(0, 0, 0, 2, 0, 0);
        List<Integer> input6 = List.of(0, 0, 1, 2, 4, 0);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(input1);
        arr.add(input2);
        arr.add(input3);
        arr.add(input4);
        arr.add(input5);
        arr.add(input6);
        int maxHourglass = -9*36;

        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2);
                sum += arr.get(i+1).get(j+1);
                sum += arr.get(i+2).get(j)+ arr.get(i+2).get(j+1) +arr.get(i+2).get(j+2);
                if(sum>maxHourglass) {
                    maxHourglass = sum;
                }
            }
        }
        Assertions.assertEquals(19, maxHourglass);
    }


    // https://www.hackerrank.com/challenges/30-scope/problem?isFullScreen=true
    @Test //14/30
    void scopeTest(){

        int[] a = {1, 2, 5};
        Difference difference = new Difference(a);
        difference.computeDifference();
        System.out.println(difference.maximumDifference);


    }
    // https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/problem
    @Test //16/30
    void exceptions(){

        try{
            int input = Integer.parseInt("s");
            System.out.println(input);
        }catch(NumberFormatException nfe){
            System.out.println("Bad String");
            Assertions.assertNotNull(nfe);
        }

        try{
            int input = Integer.parseInt("4");
            System.out.println(input);
            Assertions.assertEquals(4, input);
        }catch(NumberFormatException nfe){
            System.out.println("Bad String");
        }

    }


    // https://www.hackerrank.com/challenges/30-more-exceptions/problem
    @Test // 17/30
    void moreExceptions(){

        int n=4, p=4;
        try {
            double exponential = Math.pow(n, p);
            if(n < 0 || p < 0){
                throw new Exception("n and p should be non-negative");
            }
            Assertions.assertEquals(256, (int)exponential);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            n = -4;
            double exponential = Math.pow(n, p);
            if(n < 0 || p < 0){
                throw new Exception("n and p should be non-negative");
            }

        } catch (Exception e) {
            System.out.println(e);
            Assertions.assertNotNull(e);
        }
    }


    // https://www.hackerrank.com/challenges/30-queues-stacks/problem
    Queue<Character> characterQueue = new LinkedList<>();
    Stack<Character> characterStack = new Stack<>();

    @Test //18/30
    void queuesAndStack(){
        String input = "racecar"; // madam
        char[] s = input.toCharArray();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            pushCharacter(c);
            enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (popCharacter() != dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }
        Assertions.assertTrue(isPalindrome);
    }

    @Test
    void interfacesTest(){

        InterfacesTest interfacesTest = new InterfacesTest();

        Assertions.assertEquals(12, interfacesTest.divisorSum(6));
        Assertions.assertEquals(42, interfacesTest.divisorSum(20));

    }

    private void pushCharacter(Character c){
        characterQueue.add(c);
    }

    private void enqueueCharacter(Character c) {
        characterStack.push(c);
    }

    private Character popCharacter(){
        return characterStack.pop();
    }

    private Character dequeueCharacter() {
        return characterQueue.poll();
    }


}
