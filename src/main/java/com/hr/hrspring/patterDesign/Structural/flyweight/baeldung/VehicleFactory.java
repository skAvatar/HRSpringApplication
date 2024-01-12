package com.hr.hrspring.patterDesign.Structural.flyweight.baeldung;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class VehicleFactory {

    private static Map<Color, Vehicle> vehicleCache = new HashMap<>();

    public static Vehicle create(Color color){
        Vehicle newVehicle = vehicleCache.computeIfAbsent(color, newColor ->{
            Engine newEngine = new Engine();
            return new Vehicle(newEngine, newColor);

        });
        return newVehicle;
    }

}
