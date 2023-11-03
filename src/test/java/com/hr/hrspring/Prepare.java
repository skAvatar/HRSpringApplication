package com.hr.hrspring;

import com.hr.hrspring.Intro.dto.Pin;
import com.hr.hrspring.Intro.dto.UserStats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@SpringBootTest
public class Prepare {

    @Test
    public void pinterest() {
        ArrayList<ArrayList<Pin>> grid = new ArrayList();
        Pin pon0 = new Pin(1L, 300L);
        Pin pon1 = new Pin(2L, 250L);
        Pin pon2 = new Pin(3L, 200L);
        Pin pon3 = new Pin(4L, 350L);
        Pin pon4 = new Pin(5L, 100L);

        ArrayList<Pin> pins = new ArrayList<>();
        pins.add(pon0);
        pins.add(pon1);
        pins.add(pon2);
        pins.add(pon3);
        pins.add(pon4);

        ArrayList<Long> orderColumns = new ArrayList<>();

        int columnsAmount = 2;

        for (Pin actualPin : pins) {
            for (int index = 0; index < columnsAmount; index++) {
                if (grid.get(index).isEmpty()) {
                    ArrayList<Pin> newGrid = new ArrayList<>();
                    newGrid.add(actualPin);
                    orderColumns.add(actualPin.getHeight());
                    grid.get(index).addAll(newGrid);
                } else {
                    Long minHeight = Long.MAX_VALUE;
                    int position = 0;
                    for (Long actualHeight : orderColumns) {

                        if (minHeight > actualHeight) {
                            minHeight = actualHeight;
                            position = index;
                        }
                    }
                    grid.get(position).add(actualPin);
                    Long newHeight = orderColumns.get(position) + actualPin.getHeight();

                    orderColumns.set(position, newHeight);
                    System.out.println("orderColumns > " + orderColumns);

                }
            }
        }

        System.out.println("grid > " + grid);
    }

    @Test
    void testCountFile3() throws IOException {

        String input =new String( Files.readAllBytes((Paths.get("C:\\Users\\emarin\\Documents\\work\\Training\\hrspring\\src\\main\\resources\\files\\example3.txt"))));

        String[] inputString = input.split("\n");
        int totalLines = 0;
        int whiteSpace = 0;
        int singleComment = 0;
        for (String actualString: inputString){
            if(actualString.trim().equals("")){
                whiteSpace+=1;
            }
            if(actualString.trim().startsWith("//")){
                singleComment++;
            }
            totalLines+=1;
        }
        totalLines = totalLines - (whiteSpace + singleComment);
        System.out.println("whiteSpace > " + whiteSpace);
        System.out.println("totalLines > " + totalLines);
        Assertions.assertEquals(5, totalLines);
    }

    @Test
    void testCountFile4() throws IOException {

        String input =new String( Files.readAllBytes((Paths.get("C:\\Users\\emarin\\Documents\\work\\Training\\hrspring\\src\\main\\resources\\files\\example4.txt"))));

        String[] inputString = input.split("\n");
        int totalLines = 0;
        int whiteSpace = 0;
        int singleComment = 0;
        for (String actualString: inputString){
            if(actualString.trim().equals("")){
                whiteSpace+=1;
            }
            if(actualString.trim().startsWith("//")){
                singleComment++;
            }
            totalLines+=1;
        }
        totalLines = totalLines - (whiteSpace + singleComment);
        System.out.println("totalLines > " + totalLines);
        Assertions.assertEquals(5, totalLines);
    }

    @Test
    void testCountFile5() throws IOException {

        String input =new String( Files.readAllBytes((Paths.get("C:\\Users\\emarin\\Documents\\work\\Training\\hrspring\\src\\main\\resources\\files\\example5.java"))));

        String[] inputString = input.split("\n");
        int totalLines = 0;
        int whiteSpace = 0;
        int singleComment = 0;
        int multipleComments = 0;
        boolean isMultiple = false;
        for (String actualString: inputString){
            if(actualString.trim().length() == 0){
                whiteSpace+=1;
                continue;
            }
            if(actualString.trim().startsWith("//")){
                singleComment+=1;
                continue;
            }
            if(actualString.trim().startsWith("/*")){
                multipleComments+=1;
                isMultiple = true;
                continue;
            }
            if (actualString.trim().endsWith("*/") || actualString.trim().startsWith("*/")) {
                multipleComments+=1;
                isMultiple = false;
                continue;
            }
            if(isMultiple){
                multipleComments+=1;
            }

        }
        totalLines = inputString.length - (whiteSpace + singleComment + multipleComments);
        System.out.println("whiteSpace > " + whiteSpace);
        System.out.println("singleComment > " + singleComment);
        System.out.println("multipleComments > " + multipleComments);
        System.out.println("totalLines > " + totalLines);
        Assertions.assertEquals(5, totalLines);
    }

    @Test
    void testCountFile6() throws IOException {

        String input =new String( Files.readAllBytes((Paths.get("C:\\Users\\emarin\\Documents\\work\\Training\\hrspring\\src\\main\\resources\\files\\example6.java"))));

        String[] inputString = input.split("\n");
        int totalLines = 0;
        int whiteSpace = 0;
        int singleComment = 0;
        int multipleComments = 0;
        boolean isMultiple = false;
        for (String actualString: inputString){
            actualString= actualString.trim();
            if(actualString.length() == 0){
                whiteSpace+=1;
                continue;
            }
            if(actualString.trim().startsWith("//")){
                singleComment+=1;
                continue;
            }
            if(actualString.startsWith("/*")){
                if(actualString.endsWith("/") || actualString.endsWith("*")){
                    multipleComments+=1;
                    isMultiple = true;
                    continue;
                }
            }

            if (actualString.endsWith("*/") || actualString.startsWith("*/")) {
                multipleComments+=1;
                isMultiple = false;
                continue;
            }
            if(isMultiple){
                multipleComments+=1;
            }

        }
        totalLines = inputString.length - (whiteSpace + singleComment + multipleComments);
        System.out.println("whiteSpace > " + whiteSpace);
        System.out.println("singleComment > " + singleComment);
        System.out.println("multipleComments > " + multipleComments);
        System.out.println("total files lines > " + inputString.length);
        System.out.println("totalLines > " + totalLines);
        Assertions.assertEquals(6, totalLines);


/*


SELECT [FirstName],
    [LastName],
    [Country],
    COUNT(*) AS CNT
FROM [SampleDB].[dbo].[Employee]
GROUP BY [FirstName],
      [LastName],
      [Country]
HAVING COUNT(*) > 1;



DELETE FROM [SampleDB].[dbo].[Employee]
        WHERE ID NOT IN
        (
                SELECT MAX(ID) AS MaxRecordID
        FROM [SampleDB].[dbo].[Employee]
        GROUP BY [FirstName],
                 [LastName],
                 [Country]
    );*/
    }

    @Test
    void testCountFile7() throws IOException {

        String input =new String( Files.readAllBytes((Paths.get("C:\\Users\\emarin\\Documents\\work\\Training\\hrspring\\src\\main\\resources\\files\\example7.java"))));

        String[] inputString = input.split("\n");
        int totalLines = 0;
        int whiteSpace = 0;
        int singleComment = 0;
        int multipleComments = 0;
        boolean isMultiple = false;
        for (String actualString: inputString){
            actualString = actualString.trim();
            if(actualString.length() == 0){
                whiteSpace+=1;
                continue;
            }
            if(actualString.startsWith("//")){
                singleComment+=1;
                continue;
            }
            if(actualString.startsWith("/*")){
                if(actualString.endsWith("/") || actualString.endsWith("*")){
                    multipleComments+=1;
                    isMultiple = true;
                    continue;
                }
            }

            if (actualString.endsWith("*/") || actualString.trim().startsWith("*/")) {
                multipleComments+=1;
                isMultiple = false;
                continue;
            }
            if(isMultiple){
                multipleComments+=1;
            }

        }
        totalLines = inputString.length - (whiteSpace + singleComment + multipleComments);
        System.out.println("whiteSpace > " + whiteSpace);
        System.out.println("singleComment > " + singleComment);
        System.out.println("multipleComments > " + multipleComments);
        System.out.println("total files lines > " + inputString.length);
        System.out.println("totalLines > " + totalLines);
        Assertions.assertEquals(6, totalLines);
    }


    @Test
    void complementDna(){
        // A -> T
        // C -> G
        String sInput = "ACCGGGTTTT";
        sInput = reverString(sInput);
        String resultExpected = "AAAACCCGGT";
        Assertions.assertEquals(resultExpected, sInput);
    }

    String reverString(String input ){
        char[] charS= input.toCharArray();

        StringBuilder s = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for(int i = input.length() -1 ; i >= 0; i--){
            s.append(charS[i]);
            switch (String.valueOf(charS[i])) {
                case "A" -> result.append("T");
                case "T" -> result.append("A");
                case "C" -> result.append("G");
                case "G" -> result.append("C");
                default -> {
                }
            }
        }

        return result.toString();
    }


    @Test
    void KUniqueCharacters() {
        String str = "2aabacbebebe";
        int amount = Integer.valueOf(str.substring(0, 1));

        int end = 0, begin = 0;

        Set<Character> window = new HashSet<>();

        // Count array `freq` stores the frequency of characters present in the
        // current window. We can also use a map instead of a count array.
        HashMap<Character, Integer> freq = new HashMap<>();

        // `[low…high]` maintains the sliding window boundaries
        for (int low = 0, high = 0; high < str.length(); high++)
        {
            window.add(str.charAt(high));
            freq.putIfAbsent(str.charAt(high), 1);

            // if the window size is more than `k`, remove characters from the left
            while (window.size() > amount)
            {
                // If the leftmost character's frequency becomes 0 after
                // removing it in the window, remove it from the set as well
                if (freq.get(str.charAt(low)) - 1 == 0) {
                    window.remove(str.charAt(low));
                }

                low++;        // reduce window size
            }

            // update the maximum window size if necessary
            if (end - begin < high - low)
            {
                end = high;
                begin = low;
            }
        }

        // return the longest substring found at `str[begin…end]`
        System.out.println(str.substring(begin, end + 1));




        //System.out.println(distinct);

    }


    @Test
    void minimumCost() {

        List<Integer> arr = Arrays.asList(25, 10, 20);
        PriorityQueue<Integer> queue = new PriorityQueue<>(arr);
        Integer minimumCost = 0;

        Integer sumValue = queue.poll();
        while (!queue.isEmpty()) {
            Integer actualValue = queue.poll();
            if (sumValue > actualValue) {
                queue.add(sumValue);
                sumValue = actualValue;
            } else {
                sumValue += actualValue;
                minimumCost += sumValue;
                continue;
            }

            sumValue += queue.poll();
            minimumCost += sumValue;
        }
        System.out.println(minimumCost);
    }

    @Test
    void signalFilter() {

        List<Integer> lis1 = Arrays.asList(10, 17);
        List<Integer> lis2 = Arrays.asList(13, 15);
        List<Integer> lis3 = Arrays.asList(13, 17);

        List<List<Integer>> filterRanges = new ArrayList<>();
        filterRanges.add(lis1);
        filterRanges.add(lis2);
        filterRanges.add(lis3);

        Integer min = Integer.MAX_VALUE, max = 0;
        for (List<Integer> actualFilter : filterRanges) {

            if (actualFilter.get(0) > max) {
                max = actualFilter.get(0);
            }

            if (actualFilter.get(1) < min) {
                min = actualFilter.get(1);
            }

        }

        List<Integer> frequencies = Arrays.asList(8, 15, 14, 16, 21);

        Integer countPass = 0;
        for (Integer actualFreq : frequencies) {
            if (max <= actualFreq && actualFreq <= min) {
                countPass++;
            }
        }

        System.out.println(max);
        System.out.println(min);
        System.out.println(countPass);

    }


    @Test
    void visitCounter() {
        UserStats usr1 = new UserStats();
        UserStats usr2 = new UserStats();
        UserStats usr3 = new UserStats();
        UserStats usr4 = new UserStats();

        usr1.setVisitCount(Optional.of(10L));
        usr2.setVisitCount(Optional.empty());
        usr3.setVisitCount(Optional.of(30L));
        usr4.setVisitCount(Optional.of(40L));
        Map<String, UserStats> visits = new HashMap<>();

        Map<Long, Long> mapVisitCounter = new HashMap<>();
        visits.put("9890opop", usr1);
        visits.put("2", usr2);
        visits.put("3", usr3);
        visits.put("4", usr4);

        if ( visits != null && !visits.isEmpty()) {
            System.out.println("calculate input");
            for (String actualKey : visits.keySet()) {
                if (actualKey.matches("\\d*")) {

                    if (visits.get(actualKey).getVisitCount().isPresent()) {
                        mapVisitCounter.put(Long.valueOf(actualKey), visits.get(actualKey).getVisitCount().get());
                    }
                }
            }
        }

        System.out.println(mapVisitCounter);

    }




}


