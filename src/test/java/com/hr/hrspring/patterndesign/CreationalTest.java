package com.hr.hrspring.patterndesign;

import com.hr.hrspring.enums.Cities;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.ClientAbstractFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.factory.DatabaseConcreteFactory;
import com.hr.hrspring.patterDesign.Creational.abstractfactory.factory.NetworkConcreteFactory;
import com.hr.hrspring.patterDesign.Creational.builder.Apartment;
import com.hr.hrspring.patterDesign.Creational.builder.ApartmentBuilder;
import com.hr.hrspring.patterDesign.Creational.builder.Director;
import com.hr.hrspring.patterDesign.Creational.factorymethod.Payment;
import com.hr.hrspring.patterDesign.Creational.factorymethod.PaymentFactory;
import com.hr.hrspring.patterDesign.Creational.factorymethod.PaymentMethod;
import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.CreditCardPayment;
import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.PaypalPayment;
import com.hr.hrspring.patterDesign.Creational.prototype.Bicycle;
import com.hr.hrspring.patterDesign.Creational.prototype.Car;
import com.hr.hrspring.patterDesign.Creational.prototype.Vehicle;
import com.hr.hrspring.patterDesign.Creational.singleton.SingletonBasic;
import com.hr.hrspring.patterDesign.Creational.singleton.SingletonThreadSafe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CreationalTest {

    @Test
    void factoryMethodTest() {
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
    void abstractFactoryTest() {

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
        Assertions.assertEquals(Cities.TUCUPITA.city, medium.getCity());
        Assertions.assertEquals(Cities.PTO_ORDAZ.city, high.getCity());

    }

    @Test
    void prototypeTest() {

        Vehicle v1 = new Car(4, 350000L, "Blood Red");
        Vehicle v2 = v1.clone();

        Assertions.assertEquals(v2.getWheels(), v1.getWheels());
        Assertions.assertEquals(v2.getPrice(), v1.getPrice());
        Assertions.assertEquals(((Car) v2).getColor(), ((Car) v1).getColor());

        Vehicle bicycle1 = new Bicycle(2, 25000, true);
        Vehicle bicycle2 = bicycle1.clone();

        Assertions.assertEquals(bicycle2.getWheels(), bicycle1.getWheels());
        Assertions.assertEquals(bicycle2.getPrice(), bicycle1.getPrice());
        Assertions.assertEquals(((Bicycle) bicycle2).isCityBike(), ((Bicycle)bicycle1).isCityBike());

    }

    @Test
    void singletonTest() {

        SingletonBasic.getInstance().setData(new Car(4, 350000L, "Red"));
        Car testSingleton = (Car)SingletonBasic.getInstance().getData();
        Assertions.assertEquals("Red",testSingleton.getColor() );

        SingletonBasic.getInstance().setData(new Car(5, 35000L, "Blue"));

        Car testSingleton2 = (Car)SingletonBasic.getInstance().getData();
        Assertions.assertEquals("Blue",testSingleton2.getColor() );

    }

    @Test
    void SingletonThreadSafeTest() throws InterruptedException {
        int threadsAmount = 100;
        Set<SingletonThreadSafe> singletonSet = Collections.newSetFromMap(new ConcurrentHashMap<>());

        ExecutorService executorService = Executors.newFixedThreadPool(threadsAmount);

        for (int i = 0; i < threadsAmount; i++) {
            executorService.execute(() -> {
                SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
                singleton.setData(new Bicycle(2, 24000L, false));
                singletonSet.add(singleton);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        Assertions.assertTrue(singletonSet.size() == 1);
    }

}
