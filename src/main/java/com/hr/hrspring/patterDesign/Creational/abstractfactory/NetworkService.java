package com.hr.hrspring.patterDesign.Creational.abstractfactory;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Service;

public class NetworkService implements Service {
    @Override
    public String getServiceRun() {
        return "Network service running";
    }
}
