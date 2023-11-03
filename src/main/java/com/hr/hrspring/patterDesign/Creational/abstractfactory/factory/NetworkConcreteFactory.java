package com.hr.hrspring.patterDesign.Creational.abstractfactory.factory;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.NetworkService;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.DSAbstractFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Response;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Service;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.NetworkResponse;

public class NetworkConcreteFactory implements DSAbstractFactory {
    @Override
    public Service createService() {
        return new NetworkService();
    }

    @Override
    public Response createResponse() {
        return new NetworkResponse();
    }
}
