package com.bankapp.Bloc.Account;

import com.bankapp.Bloc.Error.FixedAccountDepositException;
import com.bankapp.Bloc.Error.FixedAccountWithdrawalException;
import com.bankapp.Bloc.Wrapper.Constants;
import com.bankapp.Services.DepositService.DepositService;
import com.bankapp.Services.WithdrawalService.WithdrawalService;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FixedAccount extends Account{


    private Double ROI = Constants.FIXED_ACCOUNT_RI;

    private DepositService depositService = DepositService.getInstance();

    private WithdrawalService withdrawalService = WithdrawalService.getInstance();

    private Double amount;

    private Integer maturity;

    private Integer parentAccountId;

    private LocalDate createdAt = LocalDate.now();


    public FixedAccount(Integer parentAccountId,Integer fixedAccountId,Double amount,Integer maturity){
        super(fixedAccountId);
        this.parentAccountId = parentAccountId;
        this.amount = amount;
        this.maturity = maturity;
    }


    @Override
    public boolean canDeposit() {
        return this.getDeposits().isEmpty();
    }

    @Override
    public boolean canWithdraw() {

        LocalDate today = LocalDate.now();

        return today.minusYears(Constants.FIXED_ACCOUNT_TENURE).compareTo(ChronoLocalDate.from(createdAt))>0;
    }

    public DepositService depositAmount()throws FixedAccountDepositException {
        if(canDeposit()){
            return this.depositService.depositAmount(this, new Deposit(this,this.amount));
        }else{
            throw new FixedAccountDepositException();
        }
    }

    public WithdrawalService withdrawAmount() throws FixedAccountWithdrawalException {
        if(canWithdraw()){
            return this.withdrawalService.withdrawAmount(this,new Withdrawal(this,this.amount));
        }else{
            throw new FixedAccountWithdrawalException();
        }
    }

}
