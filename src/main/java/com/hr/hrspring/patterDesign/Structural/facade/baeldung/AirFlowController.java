package com.hr.hrspring.patterDesign.Structural.facade.baeldung;

import lombok.Data;

@Data
public class AirFlowController {

    private Integer airFlowMeter;

    public void takeAir(){
        System.out.println("AirFlowController > takeAir");
    }

    public void off(){
        System.out.println("AirFlowController > takeAir");
    }

}
