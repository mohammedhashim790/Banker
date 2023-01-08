package com.bankapp.Bloc.Error;

public class FixedAccountWithdrawalException extends Exception{

    public FixedAccountWithdrawalException() {
        super("Only one deposit can be hold at a time in Fixed Account");
    }
}
