package com.hr.hrspring.Intro.dto;

public class Difference {

    private int[] elements;
    public int maximumDifference;

    public  Difference(int[] elements){
        this.elements = elements;
    }

    public void computeDifference(){

        maximumDifference = 0;
        int temp = 0;
        for(int actualE:elements){
            for(int i =1; i < elements.length; i++){
                temp = Math.abs(actualE - elements[i]);
                if(temp > maximumDifference){
                    maximumDifference = temp;
                }
            }
        }
        //System.out.println("maximumDifference > " + maximumDifference);

    }

}
