package com.hr.hrspring.patterDesign.Creational.builder;

import lombok.Data;

@Data
public class Apartment {
    private int sqm; // square meters
    private int rooms;
    private String city;
    private String area;
    private boolean kitchen;

    public Apartment(int sqm, int rooms, String city, String area, boolean kitchen) {
        this.sqm = sqm;
        this.rooms = rooms;
        this.city = city;
        this.area = area;
        this.kitchen = kitchen;
    }


    public String display() {
        return "Apartment{" +
                "sqm=" + sqm +
                ", rooms=" + rooms +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", kitchen=" + kitchen +
                '}';
    }
}
