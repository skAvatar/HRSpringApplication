package com.hr.hrspring.patterndesign;

import com.hr.hrspring.enums.Cities;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.ClientAbstractFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.factory.DatabaseConcreteFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.factory.NetworkConcreteFactory;
import com.hr.hrspring.patterDesign.Creational.builder.Apartment;
import com.hr.hrspring.patterDesign.Creational.builder.ApartmentBuilder;
import com.hr.hrspring.patterDesign.Creational.builder.Director;
import com.hr.hrspring.patterDesign.Creational.factorymethod.PaymentFactory;
import com.hr.hrspring.patterDesign.Creational.factorymethod.PaymentMethod;
import com.hr.hrspring.patterDesign.Creational.factorymethod.Payment;
import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.CreditCardPayment;
import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.PaypalPayment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DesignPatternsTest {

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
    void abstractFactoryTest(){

        ClientAbstractFactory client = new ClientAbstractFactory(new DatabaseConcreteFactory());
        client.communicate();
        ClientAbstractFactory client2 = new ClientAbstractFactory(new NetworkConcreteFactory());
        client2.communicate();

    }

    @Test
    void builderTest() {
        ApartmentBuilder builder = new ApartmentBuilder();

        Apartment aptr1 = builder.sqm(120)
                .rooms(4)
                .city("City Apt1")
                .area("Area Apt1")
                .kitchen(true).build();
        System.out.println(aptr1.display());
        Assertions.assertTrue(aptr1.isKitchen());

        Apartment aptr2 = builder.sqm(200)
                .city("London").build();

        System.out.println(aptr2.display());
        Assertions.assertNotNull(aptr2.getCity());

    }

    @Test
    void builderDirectorTest() {
        ApartmentBuilder builder = new ApartmentBuilder();
        Director director = new Director(builder);
        Apartment basic = director.createBasic().build();
        Apartment medium = director.createMedium().build();
        Apartment high = director.createHigh().build();

        Assertions.assertTrue(basic.isKitchen());
        Assertions.assertEquals(Cities.TUCUPITA.city,medium.getCity());
        Assertions.assertEquals(Cities.PTO_ORDAZ.city,high.getCity());

    }

}
