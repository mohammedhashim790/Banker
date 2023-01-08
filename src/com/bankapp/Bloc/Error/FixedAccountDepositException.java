package com.bankapp.Bloc.Error;

public class FixedAccountDepositException extends Exception{

    public FixedAccountDepositException() {
        super("Only one deposit can be hold at a time in Fixed Account");
    }
}
