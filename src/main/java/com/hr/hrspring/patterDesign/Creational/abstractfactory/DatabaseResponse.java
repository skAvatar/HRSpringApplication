package com.hr.hrspring.patterDesign.Creational.abstractfactory;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Response;

public class DatabaseResponse implements Response {
    @Override
    public String getResponse() {
        return "Database Response";
    }
}
