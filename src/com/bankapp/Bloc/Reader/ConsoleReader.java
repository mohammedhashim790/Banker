package com.bankapp.Bloc.Reader;

import com.bankapp.Application;
import com.bankapp.Bloc.Account.Account;
import com.bankapp.Bloc.Account.Deposit;
import com.bankapp.Bloc.Account.Transfer;
import com.bankapp.Bloc.Account.Withdrawal;
import com.bankapp.Bloc.Wrapper.Command;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleReader implements IReader{

//    Considering the buffer size is little.
    private Scanner scanner = new Scanner(System.in);

    private Application application = Application.getApplication();


    public ConsoleReader(){

    }

    @Override
    public Integer nextInt() {
        return this.scanner.nextInt();
    }

    @Override
    public Double nextDouble() {
        return this.scanner.nextDouble();
    }

    @Override
    public String next() {
        return this.scanner.next();
    }

    @Override
    public String nextLine() {
        return this.scanner.nextLine();
    }

    @Override
    public boolean hasNextLine() {
        return this.scanner.hasNextLine();
    }

    @Override
    public Character nextChar() {
        return this.scanner.next().charAt(0);
    }

    @Override
    public Deposit nextDeposit() {
        return new Deposit(this.application.getAccount(this.nextInt()),this.nextDouble());
    }

    @Override
    public Transfer nextTransfer() {
        return new Transfer(
                this.application.getAccount(this.nextInt()),
                this.application.getAccount(this.nextInt()),
                this.nextDouble());
    }

    @Override
    public Withdrawal nextWithdrawal() {
        return new Withdrawal(
                this.application.getAccount(this.nextInt()),
                this.nextDouble());
    }



    @Override
    public boolean hasNext() {
        return this.scanner.hasNext();
    }

    @Override
    public Command nextCommand() {
        return Command.valueOf(this.next().toUpperCase(Locale.ROOT));
    }

    @Override
    public Account nextNewAccount() {
        return new Account(application.getNextAccountID(),this.next());
    }

    @Override
    public Account nextExistingAccount() {
        return this.application.getAccountList().get(this.nextInt());
    }
}
