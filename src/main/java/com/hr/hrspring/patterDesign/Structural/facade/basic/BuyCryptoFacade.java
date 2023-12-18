package com.hr.hrspring.patterDesign.Structural.facade.basic;

import com.hr.hrspring.services.DatabaseService;

public class BuyCryptoFacade {

    public void buyCryptoCurrency(double amount, String currency){
        DatabaseService dbService =  new DatabaseService();
        User user = dbService.getUser(UIService.getLoggedInUserId());
        if(user.getBalance() < amount){
            System.out.print("Insufficient balance to perform transaction");
            return;
        }
        CryptoFactory.getCryptoService(currency).buyCurrency(user, amount);
        MailService mailService = new MailService();
        mailService.sendConfirmation(user);

    }

}
