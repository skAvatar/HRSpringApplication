package com.hr.hrspring.patterDesign.Structural.adapter;


import lombok.Data;

@Data
public class DisplayData {

    public String data;
    public Long number;

    public DisplayData(String data, Long number) {
        this.data = data;
        this.number = number;
    }

    @Override
    public String toString() {
        return "DisplayData{" +
                "data='" + data + '\'' +
                ", number=" + number +
                '}';
    }
}
