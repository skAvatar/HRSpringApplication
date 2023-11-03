package com.hr.hrspring.patterDesign.Creational.abstractfactory;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Response;

public class NetworkResponse implements Response {
    @Override
    public String getResponse() {
        return "Network Response";
    }
}
