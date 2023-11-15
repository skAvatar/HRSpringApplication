package com.hr.hrspring.patterDesign.Structural.bridge.inherence.impl;

import com.hr.hrspring.patterDesign.Structural.bridge.inherence.abs.Pizza;

public class PepperonPizza extends Pizza {

    @Override
    public void assemble(){
        System.out.println("Adding sauce > " + sauce);
        System.out.println("Adding toppings > " + toppings);
        System.out.println("Adding pepperoni");
    }

    @Override
    public void qualityCheck() {
        System.out.println("Crust is > " + crust);
    }


}
