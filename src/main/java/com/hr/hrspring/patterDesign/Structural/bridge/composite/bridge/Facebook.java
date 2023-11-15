package com.hr.hrspring.patterDesign.Structural.bridge.composite.bridge;

import com.hr.hrspring.patterDesign.Structural.bridge.composite.abs.Application;
import com.hr.hrspring.patterDesign.Structural.bridge.composite.abs.Phone;

public class Facebook implements Application {
    // Bridge
    // Facebook - IG [phone using Application]
    private Phone phone;
    public Facebook(Phone phone){
        this.phone = phone;
    }

    @Override
    public void runApplication() {
        System.out.println("Facebook--------------------------");
        phone.upload("Upload to Facebook");
        boolean resDownload = phone.download("download from Facebook", false);
        System.out.println("resDown > " +  resDownload);
        phone.display("Display from Facebook");
        System.out.println();
    }
}

