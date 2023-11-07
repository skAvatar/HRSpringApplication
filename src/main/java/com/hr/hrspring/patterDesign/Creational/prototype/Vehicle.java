package com.hr.hrspring.patterDesign.Creational.prototype;


import lombok.Data;

@Data
public abstract class Vehicle {
    public int wheels;
    public long price;

    public Vehicle(){}

    public Vehicle(Vehicle target){
       this.wheels = target.wheels;
       this.price = target.price;
    }

    public abstract Vehicle clone();
}
