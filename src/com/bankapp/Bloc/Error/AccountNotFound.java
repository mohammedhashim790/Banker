package com.bankapp.Bloc.Error;

public class AccountNotFound extends Exception {

    public AccountNotFound() {
        super("Account Not Found Exception. Please try again");
    }
}
