package com.hr.hrspring.patterDesign.Structural.facade.basic;

import lombok.Data;

@Data
public class CryptoFactory {

    CryptoService cryptoService;

    static CryptoService getCryptoService(String currency){
        System.out.println("Getting Crypto Service > ");
        return new CryptoService();
    }
}

class CryptoService{

    public void buyCurrency(User user, double amount){
        System.out.println("buyCurrency > for user " + user.getId() +" with the amount " + amount);
    }


}
