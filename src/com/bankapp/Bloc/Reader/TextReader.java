package com.bankapp.Bloc.Reader;

import com.bankapp.Application;
import com.bankapp.Bloc.Account.*;
import com.bankapp.Bloc.Wrapper.Command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class TextReader implements IReader{

    private Scanner scanner;

    private Application application = Application.getApplication();



    TextReader(String filename) throws FileNotFoundException {
        this.scanner = new Scanner(new FileInputStream(filename));
    }

    public TextReader(File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
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

    @Override
    public FixedAccount nextFixedAccount() {

//         Get Account Details
        Account account = application.getAccount(this.nextInt());

        return new FixedAccount(
                account.getAccountId(),
                account.getNewFixedAccountId(),
                this.nextDouble(),
                this.nextInt());
    }
}
