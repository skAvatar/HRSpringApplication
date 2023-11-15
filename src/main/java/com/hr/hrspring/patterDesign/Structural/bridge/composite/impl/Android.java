package com.hr.hrspring.patterDesign.Structural.bridge.composite.impl;

import com.hr.hrspring.patterDesign.Structural.bridge.composite.abs.Phone;

public class Android implements Phone {
    @Override
    public void upload(String data) {
        System.out.println("Android upload data > " + data);
    }

    @Override
    public boolean download(String url, boolean resDown) {
        System.out.println("Android download url > " + url);
        return resDown;
    }

    @Override
    public void display(String data) {
        System.out.println("Android display data > " + data);
    }
}
