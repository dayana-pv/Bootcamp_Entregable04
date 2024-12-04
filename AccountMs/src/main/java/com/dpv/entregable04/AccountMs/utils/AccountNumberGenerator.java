package com.dpv.entregable04.AccountMs.utils;

import org.springframework.stereotype.Component;

//@Component
public class AccountNumberGenerator {
    private static AccountNumberGenerator instance;

    private AccountNumberGenerator(){

    }

    public static AccountNumberGenerator getInstance() {
        if (instance == null) {
            instance = new AccountNumberGenerator();
        }
        return instance;
    }

    public String accountNumberGenerator() {
        return String.format("%08d", (int)(Math.random() * 100000000));
    }

}
