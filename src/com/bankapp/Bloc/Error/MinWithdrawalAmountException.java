package com.bankapp.Bloc.Error;

public class MinWithdrawalAmountException extends Exception {
    public MinWithdrawalAmountException() {
        super("Minimum Withdrawal Amount Exception");
    }
}
