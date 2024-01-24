package com.hr.hrspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UCarDTO {

    private final Integer id;
    private final String make;
    private final String model;
    private final String color;
    private final Integer year;
    private final Double price;

    public static UCarDTO map(UCar uCar) {
        return new UCarDTO(uCar.getId(), uCar.getMake(), uCar.getModel(), uCar.getColor(), uCar.getYear(), uCar.getPrice());
    }


}
