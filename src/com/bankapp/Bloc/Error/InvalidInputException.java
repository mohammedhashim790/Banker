package com.bankapp.Bloc.Error;

public class InvalidInputException extends Exception {
    InvalidInputException() {
        super("Invalid Input Exception. Please try again");
    }
}
