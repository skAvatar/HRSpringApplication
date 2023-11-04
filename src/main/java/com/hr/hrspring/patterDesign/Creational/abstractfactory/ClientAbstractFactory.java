package com.hr.hrspring.patterDesign.Creational.abstractfactory;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.DSAbstractFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Response;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Service;

public class ClientAbstractFactory {
    Service service;
    Response response;

    public ClientAbstractFactory (DSAbstractFactory factory){
        service = factory.createService();
        response = factory.createResponse();
    }

    public void communicate(){
        if(service != null && response != null){
            System.out.println(service.getServiceRun());
            System.out.println(response.getResponse());
        }
    }
}
