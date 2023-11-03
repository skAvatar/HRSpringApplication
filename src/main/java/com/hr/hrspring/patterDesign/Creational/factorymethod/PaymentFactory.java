package com.hr.hrspring.patterDesign.Creational.factorymethod;

import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.CreditCardPayment;
import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.GooglePayment;
import com.hr.hrspring.patterDesign.Creational.factorymethod.objects.PaypalPayment;

public class PaymentFactory {

    public static Payment create (PaymentMethod paymentMethod) throws ClassNotFoundException {

        switch (paymentMethod){
            case CREDIT_CARD -> {
                return new CreditCardPayment();
            }
            case PAYPAL -> {
                return new PaypalPayment();
            }
            case GOOGLE_PAY -> {
                return new GooglePayment();
            }
            default -> {
                throw  new ClassNotFoundException("");
            }
        }
    }
}
