package com.bankapp.Bloc.Error;

public class MinimumAccountBalanceException extends Exception {
    public MinimumAccountBalanceException(Double balance) {
        super("Minimum Account Balance Exception. Current Balance : " + balance);
    }
}
