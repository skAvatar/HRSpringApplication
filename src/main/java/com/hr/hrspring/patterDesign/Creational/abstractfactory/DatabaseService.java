package com.hr.hrspring.patterDesign.Creational.abstractfactory;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Service;

public class DatabaseService implements Service {

    @Override
    public String getServiceRun() {
        return "Database service running";
    }
}
