package com.hr.hrspring.patterDesign.Structural.composite.basic;

import java.util.ArrayList;

public class Composite extends Equipment{

    private ArrayList<Equipment> equipments = new ArrayList<>();

    public Composite(String name){
        super(name, 0);
    }

    public Composite add(Equipment equipment){
        equipments.add(equipment);
        return this;
    }

    @Override
    public int getPrice(){
        int sum = equipments.stream()
                .mapToInt( e -> e.getPrice()).sum();
        return sum;
    }
}
