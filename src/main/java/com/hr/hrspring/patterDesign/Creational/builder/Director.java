package com.hr.hrspring.patterDesign.Creational.builder;

public class Director {

    private ApartmentBuilder builder;
    public Director(ApartmentBuilder builder){
        this.builder = builder;
    }

    public ApartmentBuilder createBasic(){
        return builder.sqm(80)
                .rooms(2)
                .area("San Jose")
                .city("Cola de Mangato")
                .kitchen(true);
    }

    public ApartmentBuilder createMedium(){
        return builder.sqm(160)
                .rooms(4)
                .area("Romulo Gallegos")
                .city("Tucupita")
                .kitchen(true);
    }

    public ApartmentBuilder createHigh(){
        return builder.sqm(220)
                .rooms(8)
                .area("Romulo Gallegos")
                .city("Pto_ordaz")
                .kitchen(true);
    }




}
