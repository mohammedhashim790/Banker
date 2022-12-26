package com.bankapp.Bloc.Error;

public class MaxDepositAmountException extends Exception {
    public MaxDepositAmountException() {
        super("Maximum Deposit Amount Exception");
    }
}
