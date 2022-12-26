package com.bankapp.Services.WithdrawalService;

import com.bankapp.Bloc.Account.Account;
import com.bankapp.Bloc.Account.Withdrawal;
import com.bankapp.Bloc.Wrapper.printer;

public class WithdrawalService implements IWithdrawalService{


    private Double amount;

    public static WithdrawalService getInstance() {
        return _instance;
    }

    private static WithdrawalService _instance = InitInstance();

    private static WithdrawalService InitInstance() {
        return new WithdrawalService();
    }






    public WithdrawalService() {
    }

    @Override
    public WithdrawalService withdrawAmount(
            Account account,
            Withdrawal withdrawalAccount){

        printer.print("Withdrawing to ", withdrawalAccount.getAccountId());


        account.getWithdrawals()
                .add(withdrawalAccount);
        System.out.println(
                String.format("Amount Withdrawn Successfully to %s",account.getAccountId())
        );
        return this;
    }



}
