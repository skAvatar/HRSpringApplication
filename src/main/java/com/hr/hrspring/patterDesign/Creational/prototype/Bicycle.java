package com.hr.hrspring.patterDesign.Creational.prototype;


import lombok.Data;

@Data
public class Bicycle extends Vehicle{
    private boolean isCityBike;

    public Bicycle(Bicycle target){
        super(target);
        this.isCityBike = target.isCityBike;
    }

    public Bicycle(int wheel, long price, boolean isCityBike){
        this.wheels = wheel;
        this.price = price;
        this.isCityBike = isCityBike;
    }

    @Override
    public Vehicle clone() {
        return new Bicycle(this);
    }
}
