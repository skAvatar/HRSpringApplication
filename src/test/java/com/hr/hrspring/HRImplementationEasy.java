package com.hr.hrspring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class HRImplementationEasy {

    @Test
    public void countApplesAndOranges() {

/*        int s = 7, t = 11, a = 5, b = 15;
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

        return countFruit;
    }

    @Test
    public void kangaroo() {
        int x1 = 0, v1 = 3, x2 = 4, v2 = 2;

        boolean flag = false;
        for (int i = 1; i <= 20000; i++) {
            if ((x1 + v1) != (x2 + v2)) {
                x1 += v1;
                x2 += v2;
            } else {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // https://www.hackerrank.com/challenges/between-two-sets/problem?h_r=internal-search
    @Test
    public void betweenTwoSets() {
        //List<Integer> a = Arrays.asList(2, 3);
        List<Integer> a = Arrays.asList(5, 6, 7, 11);
        List<Integer> b = Arrays.asList(16, 32, 96);

        int countDivisor = 0;
        boolean flag = true;
        for (int i = 1; i <= 100; i++) {
            for (Integer actualA : a) {
                if ((i % actualA) != 0) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                for (Integer actualB : b) {
                    if ((actualB % i) == 0) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    countDivisor++;
                }
            }
        }
        System.out.println(countDivisor);

    }

    // tiepnguyenvantv1
    @Test
    public void betweenTwoSetsPerfect() {

        List<Integer> a = Arrays.asList(3, 9, 6);
        List<Integer> b = Arrays.asList(36, 72);
        int sizeB = b.size();
        int tem = b.get(sizeB - 1) / a.get(0);
        int count = 0;
        for (int i = 1; i <= tem; i++) {
            int x = a.get(0) * i;
            boolean checkA = a.stream().allMatch(ele -> x % ele == 0);
            boolean checkB = b.stream().allMatch(ele -> ele % x == 0);
            if (checkA && checkB) count++;
        }
        System.out.println(count);
    }

    @Test
    public void equalizeArray() {
        List<Integer> arr = Arrays.asList(37, 32, 97, 35, 76, 62);
        HashMap<Integer, Integer> mapNumber = new HashMap<>();

        int maxRepo = 1;
        for (Integer actualNumber : arr) {
            if (mapNumber.get(actualNumber) == null) {
                mapNumber.put(actualNumber, 1);
            } else {
                Integer amountRep = mapNumber.get(actualNumber);
                amountRep++;
                mapNumber.put(actualNumber, amountRep);
                if (maxRepo < amountRep) {
                    maxRepo = amountRep;
                }
            }
        }
        System.out.println("maxRepo  >" + (arr.size() - maxRepo));
    }

    //https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=true
    @Test
    public void breakingTheRecords() {
        //List<Integer> scores = Arrays.asList( 10, 5,20, 20, 4, 5, 2, 25, 1);
        List<Integer> scores = Arrays.asList(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);

        int min = Integer.MAX_VALUE, max = scores.get(0), countMin = 0, countMax = 0;
        for (Integer actualScore : scores) {
            if (actualScore > max) {
                countMax++;
                max = actualScore;
            }
            if (actualScore < min) {
                countMin++;
                min = actualScore;
            }
        }
        countMin--;
        System.out.println(countMax + " " + countMin);
        //Expected 2 4
    }

    //https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
    @Test
    public void subArrayDivision() {
        List<Integer> s = Arrays.asList(2, 2, 1, 3, 2);
        int d = 4, m = 2;  // Expected 2

/*        List<Integer> s = Arrays.asList(1, 2, 1, 3, 2);
        int d = 3,m = 2; // Expected 2*/

        int sumSeg = 0, totalSeg = 0, indexJ = 0;
        for (int i = 0; i <= s.size() - m; i++) {
            for (int j = i; (j - i) < m; j++) {
                sumSeg += s.get(j);
            }
            if (d == sumSeg) {
                totalSeg++;
            }
            sumSeg = 0;
        }
        System.out.println("totalSeg > " + totalSeg);
    }

    //https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?isFullScreen=true
    @Test
    public void divisibleSumPairs() {
        // Write your code here
/*        List<Integer> ar = Arrays.asList(1, 3, 2, 6, 1, 2);
        int k = 3; // Expected 5*/

        List<Integer> ar = Arrays.asList(1, 2, 3, 4, 5, 6);
        int k = 5;// Expected 3

        int result = 0;
        for (int i = 0; i < ar.size() - 1; i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                System.out.println("i  j > " + i + " " + j);

                if (i < j && ((ar.get(i) + ar.get(j)) % k == 0)) {
                    System.out.println("pair > " + ar.get(i) + " " + ar.get(j));
                    result++;
                }
            }

        }

        System.out.println(result);
    }

    // https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
    @Test
    public void migratoryBirds() {

/*        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4);
        // Expected 3*/

        List<Integer> arr = Arrays.asList(1, 4, 4, 4, 5, 3);
        // Expected 4

        HashMap<Integer, Integer> birdsById = new HashMap<>();
        Integer countBird = 0;

        for (Integer actualBird : arr) {
            if (birdsById.get(actualBird) == null) {
                birdsById.put(actualBird, 1);
            } else {
                Integer aob = birdsById.get(actualBird) + 1;
                birdsById.put(actualBird, aob);
            }
        }
        countBird = Collections.max(birdsById.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

        System.out.println(birdsById);
        System.out.println("countBird > " + countBird);
    }


    @Test
    public void earningTest() {

        // Celebrity 0 - 1
/*        a-> b
        a-> c
              c->a
              c->b
              b -> null  */
        HashMap<String, ArrayList<String>> searchCelebrity = new HashMap<>();


        ArrayList<String> aList = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> cList = new ArrayList<>(Arrays.asList("c", "b", "a"));
        ArrayList<String> bList = new ArrayList<>(Arrays.asList("b"));


        List<List<String>> guests = new ArrayList<>();
        guests.add(aList);
        guests.add(cList);
        guests.add(bList);

        for (List<String> actualGuests : guests) {
            for (int i = 0; i < actualGuests.size(); i++) {
                if (searchCelebrity.get(actualGuests.get(0)) == null) {
                    if (actualGuests.size() > 1) {
                        searchCelebrity.put(actualGuests.get(0), new ArrayList<>(actualGuests.subList(1, actualGuests.size() - 1)));
                    } else {
                        searchCelebrity.put(actualGuests.get(0), null);
                    }
                } else {
                    ArrayList<String> addGuest = searchCelebrity.get(actualGuests.get(0));
                    addGuest.add(actualGuests.get(i));
                    searchCelebrity.put(actualGuests.get(0), addGuest);
                }
            }
        }


        System.out.println(searchCelebrity);

    }

    @Test
    public void testCompress() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        //char[] chars = {'a'};
        //char[] chars ={'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        HashMap<String, Integer> group = new HashMap<>();

        for (char actualChar : chars) {
            String charString = String.valueOf(actualChar);
            if (group.get(charString) == null) {
                group.put(charString, 1);
            } else {
                Integer oldAmnt = group.get(charString);
                oldAmnt++;
                group.put(charString, oldAmnt);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String letter : group.keySet()) {
            if (group.get(letter) == 1) {
                builder.append(letter);
            } else {
                builder.append(letter).append(group.get(letter));
            }
        }
        System.out.println("compress >> " + builder);

        StringBuilder finalResult = new StringBuilder();
        for (char actualChar : builder.toString().toCharArray()) {
            System.out.println("actualChar >> " + actualChar);
        }

    }

    @Test
    void bigSum() {
        List<Long> numbers = Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L);
        Long result = 0L;
        for (Long actualLong : numbers) {
            result += actualLong;
        }

        Assertions.assertEquals(5000000015L, result);
    }

    @Test
    void SparseArrays() {

        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("aba", "baba", "aba", "xzxb"));
        ArrayList<String> queries = new ArrayList<>(Arrays.asList("aba", "xzxb", "ab"));

        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        for (String query : queries) {
            for (int i = 0; i < stringList.size(); i++) {
                if (query.equals(stringList.get(i))) {
                    count++;
                }
            }
            result.add(count);
            count = 0;
        }

        Assertions.assertEquals(Arrays.asList(2, 1, 0), result);

    }

    @Test
    void arrayManipulation() {
        List<List<Integer>>queries = new ArrayList<>();
        int max = 0;

        List<Integer> a =Arrays.asList(1, 5, 3);
        List<Integer> b = Arrays.asList(4, 8, 7);
        List<Integer> c = Arrays.asList(6, 9, 1);
/*        List<Integer> a =Arrays.asList(1, 2, 100);
        List<Integer> b = Arrays.asList(2, 5, 100);
        List<Integer> c = Arrays.asList(3, 4, 100);*/


/*        List<Integer> a = Arrays.asList(2, 6, 8);
        List<Integer> b = Arrays.asList(3, 6, 7);
        List<Integer> c = Arrays.asList(1, 8, 1);
        List<Integer> d = Arrays.asList(5, 9, 15);*/

        queries.add(a);
        queries.add(b);
        queries.add(c);
        //queries.add(d);

        for( int i =1; i<queries.size();i++){
            if(queries.get(i).get(0) < queries.get(i-1).get(1)){
                if((queries.get(i).get(2) + queries.get(i-1).get(2) ) > max ){
                    max = max + queries.get(i).get(2) + queries.get(i-1).get(2);
                }
            }else if(queries.get(i).get(0) > queries.get(i-1).get(1)){

            }
        }
        Assertions.assertEquals(10, max);
        //Assertions.assertEquals(200, max);
        //Assertions.assertEquals(31, max);
    }

    @Test
    void peakLElement(){

        //1 2  3 4 5 ---- Calculate average of these nos using java stream api.
        //List<Integer> elements = Arrays.asList (10,5,6,8,20,7,3,90,50);
        List<Integer> elements = Arrays.asList (1,2,3,4,5);

        elements.stream() //
                .mapToDouble(i -> i) //
                .average() //
                .ifPresent(avg -> System.out.println("Average found is " + avg));

    }

    @Test
    void equalizeTheArray(){
        // Given an array of integers, determine the minimum number of
        // elements to delete to leave only elements of equal value.
        //List<Integer> elements = Arrays.asList (3, 3, 2, 1, 3);
        List<Integer> elements = Arrays.asList (1, 2, 2, 3);
        HashMap<Integer, Integer> mapCount = new HashMap<>();

        for(Integer actualNumber: elements){
            mapCount.put(actualNumber, mapCount.getOrDefault(actualNumber, 0) + 1);
        }

        Integer maxCount = Collections.max(mapCount.values());
        Integer minimum = elements.size() - maxCount;
        System.out.println(minimum);
        Assertions.assertEquals(2, minimum);

    }




















}
