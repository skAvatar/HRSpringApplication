package com.hr.hrspring.patterDesign.Creational.abstractfactory.factory;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.DatabaseResponse;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.DatabaseService;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.DSAbstractFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Response;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Service;

public class DatabaseConcreteFactory implements DSAbstractFactory {
    @Override
    public Service createService() {
        return new DatabaseService();
    }

    @Override
    public Response createResponse() {
        return new DatabaseResponse();
    }
}
