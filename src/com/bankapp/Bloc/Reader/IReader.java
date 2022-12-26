package com.bankapp.Bloc.Reader;

import com.bankapp.Bloc.Account.Account;
import com.bankapp.Bloc.Account.Deposit;
import com.bankapp.Bloc.Account.Transfer;
import com.bankapp.Bloc.Account.Withdrawal;
import com.bankapp.Bloc.Wrapper.Command;

public interface IReader {


    public Integer nextInt();

    public Double nextDouble();

    public String next();

    public String nextLine();



    public Character nextChar();

    public Deposit nextDeposit();

    public Transfer nextTransfer();

    public Withdrawal nextWithdrawal();

    public boolean hasNext();

    public boolean hasNextLine();

    public Command nextCommand();

    public Account nextNewAccount();

    public Account nextExistingAccount();




}
