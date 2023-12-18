package com.hr.hrspring.patterDesign.Structural.facade.baeldung;

import lombok.Data;

@Data
public class FuelInjector {

    boolean fuelPump;

    public void on(){
        System.out.println("Fuel Injector On");
    }

    public void inject(){
        System.out.println("Inject");
    }
    public void off(){
        System.out.println("Fuel Injector Off");
    }
}
