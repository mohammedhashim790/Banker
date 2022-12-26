package com.bankapp.Bloc.Account;

import com.bankapp.Bloc.Error.MaxWithdrawalAmountException;
import com.bankapp.Bloc.Error.MaximumWithdrawLimitPerDayExceeded;
import com.bankapp.Bloc.Error.MinWithdrawalAmountException;
import com.bankapp.Bloc.Error.MinimumAccountBalanceException;
import com.bankapp.Bloc.Wrapper.Constants;
import com.bankapp.Services.WithdrawalService.WithdrawalService;

import java.util.Date;
import java.util.Random;

public class Withdrawal{

    private Integer accountId;
    private Integer id = new Random().nextInt(10000);

    private Date createdAt = new Date();

    private Account account;

    private Double amount;



    public Withdrawal(Account account,Double amount){
        this.account = account;
        this.accountId = account.getAccountId();
        this.amount = amount;
    }


    public Withdrawal() {
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

    public Account getAccount() {
        return account;
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



    @Override
    public String toString() {
        return "Withdrawal{" +
                "userId=" + accountId +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                '}';
    }

    public Withdrawal canWithdraw() throws Exception {
        if(this.amount < Constants.MIN_WITHDRAWAL){
            throw new MinWithdrawalAmountException();
        }
        if(this.amount>Constants.MAX_WITHDRAWAL){
            throw new MaxWithdrawalAmountException();
        }
        if((this.account.getBalance() - this.amount)<Constants.MIN_BALANCE){
            throw new MinimumAccountBalanceException(this.account.getBalance());
        }
        if(!this.account.canWithdraw()){
            throw new MaximumWithdrawLimitPerDayExceeded();
        }
        return this;
    }
}
