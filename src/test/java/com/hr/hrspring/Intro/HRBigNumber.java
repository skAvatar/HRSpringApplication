package com.hr.hrspring.Intro;

import com.hr.hrspring.Intro.utils.Prime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class HRBigNumber {

    @Test
    void primeNumber() {

        String n = "2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251983";
        BigInteger integerN = new BigInteger(n);

        if (integerN.isProbablePrime(1)){
            System.out.println("prime");
        }else{
            System.out.println("not prime");
        }
    }


    @Test
    void bigInteger() {

        String a = "4534534534564657652349234230947234723947234234823048230957349573209483057\n";
        String b = "12324000123123";

        BigInteger bigA = new BigInteger(a.trim());
        BigInteger bigB = new BigInteger(b.trim());

        System.out.println(bigA.add(bigB));
        System.out.println(bigA.multiply(bigB));

    }

    @Test
    void bigDecimal() {
        String[] args = { "-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
        String[] s = new String[args.length+2];
        ArrayList<BigDecimal> numberBd  = new ArrayList<>();
        for(String actualString: args){
            numberBd.add(new BigDecimal(actualString));
        }

        System.out.println(numberBd.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

    }

    @Test
    void checkPrime() {
        Integer n1 = 2, n2= 1, n3 = 3, n4= 5, n5=11;
        Prime ob = new Prime();
        ob.checkPrime(n1);
        ob.checkPrime(n1, n2);
        ob.checkPrime(n1, n2, n3);
        ob.checkPrime(n1, n2, n3, n4, n5);
        Method[] methods = Prime.class.getDeclaredMethods();
        Set<String> set = new HashSet<>();
        boolean overload = false;
        for (Method method : methods) {
            if (set.contains(method.getName())) {
                overload = true;
                break;
            }
            set.add(method.getName());
        }
    }



}
