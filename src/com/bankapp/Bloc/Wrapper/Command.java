package com.bankapp.Bloc.Wrapper;

public enum Command {

    CREATE,

    DEPOSIT,

    WITHDRAW,

    BALANCE,

    VIEW,

    FIXED,



    TRANSFER;




    @Override
    public String toString() {
        return super.name();
    }


}
