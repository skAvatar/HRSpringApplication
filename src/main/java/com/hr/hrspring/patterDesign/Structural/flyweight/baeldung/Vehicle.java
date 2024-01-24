package com.hr.hrspring.patterDesign.Structural.flyweight.baeldung;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private Engine engine;
    private Color color;
}
