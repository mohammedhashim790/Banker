package com.bankapp.Bloc.Error;


/**
 * List Exception to be raised during Transaction
 */


public class WithDrawLimitExceeded extends Exception{


    WithDrawLimitExceeded(){
        super("Withdraw Limit Exceeded");
    }
}








