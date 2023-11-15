package com.hr.hrspring.patterDesign.Structural.adapter;


import lombok.Data;

@Data
public class DataBaseData {

    public int position;
    public float amount;

    public DataBaseData(int position, float amount) {
        this.position = position;
        this.amount = amount;
    }
}
