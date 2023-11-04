package com.hr.hrspring.patterDesign.Creational.builder;

public class ApartmentBuilder {
    private int sqm; // square meters
    private int rooms;
    private String city;
    private String area;
    private boolean kitchen;

    public ApartmentBuilder sqm(int sqm){
        this.sqm = sqm;
        return this;
    }

    public ApartmentBuilder rooms(int rooms){
        this.rooms = rooms;
        return this;
    }

    public ApartmentBuilder city(String city){
        this.city = city;
        return this;
    }

    public ApartmentBuilder area(String area){
        this.area = area;
        return this;
    }

    public ApartmentBuilder kitchen(boolean kitchen){
        this.kitchen = kitchen;
        return this;
    }

    public Apartment build() {
        return new Apartment(sqm, rooms, city, area, kitchen);
    }
}
