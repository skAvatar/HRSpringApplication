package com.hr.hrspring.patterndesign;

import com.hr.hrspring.patterDesign.Creational.abstractfactory.factory.DatabaseConcreteFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.factory.NetworkConcreteFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.DSAbstractFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Response;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.interfaces.Service;
import com.hr.hrspring.patterDesign.Creational.factorymethod.PaymentFactory;
import com.hr.hrspring.patterDesign.Creational.factorymethod.PaymentMethod;
import com.hr.hrspring.patterDesign.Creational.factorymethod.Payment;
import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.CreditCardPayment;
import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.PaypalPayment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DesignPatterns {

    @Test
    void factoryMethodTest(){
        try {
            Payment payment = PaymentFactory.create(PaymentMethod.CREDIT_CARD);
            payment.pay(new BigDecimal("1000000.0"));
            Assertions.assertInstanceOf(CreditCardPayment.class, payment);

            Payment paymentPayment = PaymentFactory.create(PaymentMethod.PAYPAL);
            paymentPayment.pay(new BigDecimal("99999.0"));
            Assertions.assertInstanceOf(PaypalPayment.class, paymentPayment);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void abstractFactory(){


        ClientAbstractFactory client = new ClientAbstractFactory(new DatabaseConcreteFactory());

        client.communicate();

        ClientAbstractFactory client2 = new ClientAbstractFactory(new NetworkConcreteFactory());

        client2.communicate();


    }

// Client for Abstract Factory
    private static class ClientAbstractFactory{
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




}
