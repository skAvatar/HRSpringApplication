package com.hr.hrspring.patterDesign.Structural.composite.basic;

import lombok.Data;

@Data
public class Equipment {

    private String name;
    private int price;

    public Equipment(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
