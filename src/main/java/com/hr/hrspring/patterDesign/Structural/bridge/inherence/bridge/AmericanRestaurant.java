package com.hr.hrspring.patterDesign.Structural.bridge.inherence.bridge;

import com.hr.hrspring.patterDesign.Structural.bridge.inherence.abs.Pizza;
import com.hr.hrspring.patterDesign.Structural.bridge.inherence.abs.Restaurant;

public class AmericanRestaurant extends Restaurant {

    // Bridge
    // Connect Pizza - Restaurant
    // Italian - American is Implementation
    public AmericanRestaurant(Pizza pizza){
        super(pizza);
    }

    @Override
    public void addSauce() {
        pizza.setSauce("Sauce AR");
    }

    @Override
    public void addToppings() {
        pizza.setToppings("Toppings AR");
    }

    @Override
    public void makeCrust() {
        pizza.setCrust("Crust AR");
    }

}
