package com.hr.hrspring.patterDesign.Creational.prototype;


import lombok.Data;

@Data
public class Car extends Vehicle{
    private String color;

    public Car(Car target){
        super(target);
        this.color = target.color;
    }

    public Car(int wheel, long price, String color){
       this.wheels = wheel;
       this.price = price;
       this.color = color;
    }



    @Override
    public Vehicle clone() {
        return new Car(this);
    }
}
