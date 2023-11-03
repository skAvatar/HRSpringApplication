package com.hr.hrspring.patterDesign.Creational.factorymethod.objects;

import com.hr.hrspring.patterDesign.Creational.factorymethod.Payment;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println(MessageFormat.format("Successfully paid {0} CreditCard ", amount));
    }
}
