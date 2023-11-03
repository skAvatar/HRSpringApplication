package com.hr.hrspring.patterDesign.Creational.factorymethod.objects;

import com.hr.hrspring.patterDesign.Creational.factorymethod.Payment;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class GooglePayment implements Payment {
    @Override
    public void pay(BigDecimal amount) {
        System.out.printf(MessageFormat.format("Successfully paid {0} GooglePay", amount));
    }
}