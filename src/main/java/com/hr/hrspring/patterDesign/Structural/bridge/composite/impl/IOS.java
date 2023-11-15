package com.hr.hrspring.patterDesign.Structural.bridge.composite.impl;

import com.hr.hrspring.patterDesign.Structural.bridge.composite.abs.Phone;

public class IOS implements Phone {
    @Override
    public void upload(String data) {
        System.out.println("IOS upload data > " + data);
    }

    @Override
    public boolean download(String url, boolean resDown) {
        System.out.println("IOS download url > " + url);
        return true;
    }

    @Override
    public void display(String data) {
        System.out.println("IOS display data > " + data);
    }
}
