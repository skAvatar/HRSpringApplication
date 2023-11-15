package com.hr.hrspring.patterDesign.Structural.bridge.composite.abs;

public interface Phone {
    void upload (String data);
    boolean download(String url, boolean resDown);
    void display(String data);
}
