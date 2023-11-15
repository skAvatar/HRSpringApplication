package com.hr.hrspring.patterDesign.Structural.bridge.inherence.bridge;

import com.hr.hrspring.patterDesign.Structural.bridge.inherence.abs.Pizza;
import com.hr.hrspring.patterDesign.Structural.bridge.inherence.abs.Restaurant;

public class ItalianRestaurant extends Restaurant {

    // Bridge
    // Connect Pizza - Restaurant
    // Italian - American is Implementation
    public ItalianRestaurant(Pizza pizza){
        super(pizza);
    }

    @Override
    public void addSauce() {
        pizza.setSauce("Sauce IR");
    }

    @Override
    public void addToppings() {
        pizza.setToppings("Toppings IR");
    }

    @Override
    public void makeCrust() {
        pizza.setCrust("Crust IR");
    }
}
