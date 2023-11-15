package com.hr.hrspring.patterDesign.Structural.bridge.inherence.abs;

import com.hr.hrspring.patterDesign.Structural.bridge.inherence.abs.Pizza;

public abstract class Restaurant {

    protected Pizza pizza;

    protected Restaurant(Pizza pizza){
        this.pizza = pizza;
    }

    public abstract void addSauce();
    public abstract void addToppings();
    public abstract void makeCrust();

    public void deliver(){

        makeCrust();
        addSauce();
        addToppings();
        pizza.assemble();
        pizza.qualityCheck();
        System.out.println("Order in progress!");

    }



}
