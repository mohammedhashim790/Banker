package com.bankapp.Services.DepositService;

import com.bankapp.Bloc.Account.Account;
import com.bankapp.Bloc.Account.Deposit;
import com.bankapp.Bloc.Wrapper.printer;
import com.bankapp.Services.WithdrawalService.WithdrawalService;

public class DepositService implements IDepositService {


    public static DepositService getInstance() {
        return _instance;
    }

    private static DepositService _instance = InitInstance();

    private static DepositService InitInstance() {
        return new DepositService();
    }

    public DepositService() {

    }



    @Override
    public DepositService depositAmount(
            Account account,
            Deposit depositAccount){

        printer.print("Depositing to ", depositAccount.getAccountId());


        account.getDeposits()
                .add(depositAccount);
        System.out.println(
                String.format("Amount Deposited Successfully to %s",account.getAccountId())
        );
        return this;
    }

}
