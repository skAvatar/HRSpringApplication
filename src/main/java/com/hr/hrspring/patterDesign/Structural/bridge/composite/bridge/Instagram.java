package com.hr.hrspring.patterDesign.Structural.bridge.composite.bridge;

import com.hr.hrspring.patterDesign.Structural.bridge.composite.abs.Application;
import com.hr.hrspring.patterDesign.Structural.bridge.composite.abs.Phone;

public class Instagram implements Application {
    // Bridge
    // Facebook - IG [phone using Application]
    private Phone phone; // Bridge
    public Instagram(Phone phone){
        this.phone = phone;
    }

    @Override
    public void runApplication() {
        System.out.println("Instagram--------------------------");
        phone.upload("Upload to Instagram");
        boolean resDownload = phone.download("download from Instagram", true);
        System.out.println("resDown > " +  resDownload);
        phone.display("Display on Instagram");
        System.out.println();
    }
}

