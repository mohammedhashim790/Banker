package com.bankapp.Bloc.Error;

public class MinDepositAmountException extends Exception {
    public MinDepositAmountException() {
        super("Minimum Deposit Amount Exception");
    }
}
