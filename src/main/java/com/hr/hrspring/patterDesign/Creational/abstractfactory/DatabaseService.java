package com.hr.hrspring.patterDesign.Creational.abstractfactory;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Service;
import com.hr.hrspring.patterDesign.Creational.builder.Apartment;

public class DatabaseService implements Service {

    @Override
    public String getServiceRun() {
        return "Database service running";
    }
}
