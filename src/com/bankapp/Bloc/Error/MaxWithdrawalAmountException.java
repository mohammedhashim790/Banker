package com.bankapp.Bloc.Error;

public class MaxWithdrawalAmountException extends Exception {
    public MaxWithdrawalAmountException() {
        super("Maximum Withdrawal Amount Exceeded");
    }
}
