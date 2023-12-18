package com.hr.hrspring.patterDesign.Structural.facade.baeldung;

public class CoolingController {

    private String radiator;
    private boolean temperatureSensor;

    public void setTemperatureUpperLimit(int temp){
        System.out.println("CoolingController > setTemperatureUpperLimit > " + temp );
    }

    public void run(){
        System.out.println("CoolingController > run");
    }

    public void cool(int coolingNbr){
        System.out.println("CoolingController > cool > " + coolingNbr);
    }

    public void stop(){
        System.out.println("CoolingController > stop");
    }




}
