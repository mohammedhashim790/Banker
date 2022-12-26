package com.bankapp.Bloc.Account;

import com.bankapp.Application;

public class Transfer {



    private Account sourceAccount;

    private Account beneficiaryAccount;



    private Double amount;


    private Deposit deposit;
    private Withdrawal withdrawal;


    public Transfer(Account sourceAccount, Account beneficiaryAccount, Double amount) {
        this.sourceAccount = sourceAccount;
        this.beneficiaryAccount = beneficiaryAccount;
        this.amount = amount;

        this.deposit = new Deposit(this.beneficiaryAccount,amount);

        this.withdrawal = new Withdrawal(this.sourceAccount,amount);

    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Withdrawal getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(Withdrawal withdrawal) {
        this.withdrawal = withdrawal;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public Transfer canTransfer() throws Exception {

//        Source Account Subtracts the balance, hence Withdraw
        this.deposit.canDeposit();
//        Receiver gets credited, hence deposit
        this.withdrawal.canWithdraw();

        return this;
    }






}
