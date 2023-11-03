package com.hr.hrspring.poo.dto;


public class Student extends Person {
    
    private int[] testScores;
    public Student(String firstName, String lastName, int identification, int[] testScores){
        super( firstName, lastName, identification);
        this.testScores = testScores;
    }
    public static void methodTest(){
        System.out.println("print on student");
    }
    public char calculate(){
        int avg = 0;

        for(int scoreActual: testScores){
            avg+=scoreActual;
        }

        avg = avg/testScores.length;
        if(90 <= avg  && avg <= 100){
            return 'O';
        }
        if(80 <= avg  && avg < 90){
            return 'E';
        }
        if(70 <= avg  && avg < 80){
            return 'A';
        }
        if(55 <= avg  && avg < 70){
            return 'P';
        }
        if(40 <= avg  && avg < 55){
            return 'D';
        }
        return 'T';
    }


}
