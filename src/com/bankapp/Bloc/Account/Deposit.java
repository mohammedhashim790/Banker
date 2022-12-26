package com.bankapp.Bloc.Account;

import com.bankapp.Bloc.Error.MaxDepositAmountException;
import com.bankapp.Bloc.Error.MaximumAccountBalanceReached;
import com.bankapp.Bloc.Error.MaximumDepositLimitPerDayExceeded;
import com.bankapp.Bloc.Error.MinDepositAmountException;
import com.bankapp.Bloc.Wrapper.Constants;

import java.util.Date;
import java.util.Random;

public class Deposit{

    private Account account;
    private Integer accountId;
    private Integer id = new Random().nextInt(10000);

    private Date createdAt = new Date();

    private Double amount;


    public Deposit(Account account,Double amount){

            this.account = account;
            this.accountId = account.getAccountId();
            this.amount = amount;

    }





    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "userId=" + accountId +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                '}';
    }
    public Deposit canDeposit() throws Exception {
        if(this.amount < Constants.MIN_DEPOSITS){
            throw new MinDepositAmountException();
        }
        if(this.amount>Constants.MAX_DEPOSITS){
            throw new MaxDepositAmountException();
        }
        if((this.account.getBalance() + this.amount)>Constants.MAX_BALANCE){
            throw new MaximumAccountBalanceReached(this.account.getBalance());
        }
        if(!this.account.canDeposit()){
            throw new MaximumDepositLimitPerDayExceeded();
        }
        return this;
    }
}
