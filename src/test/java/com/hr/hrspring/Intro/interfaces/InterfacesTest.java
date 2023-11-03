package com.hr.hrspring.Intro.interfaces;


public class InterfacesTest implements AdvancedArithmetic {

    @Override
    public int divisorSum(int n) {
        int sumDiv = 0;
        for(int i =1;i <= n; i++){
            if(n%i == 0){
                sumDiv+= i;
            }

        }

        return sumDiv;
    }
}
