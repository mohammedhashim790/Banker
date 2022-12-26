package com.bankapp.Services.TransferService;

import com.bankapp.Bloc.Account.Account;
import com.bankapp.Bloc.Account.Transfer;
import com.bankapp.Services.DepositService.DepositService;
import com.bankapp.Services.WithdrawalService.WithdrawalService;

public class TransferService implements ITransferService{

    private Account sourceAccount;
    private Account beneficiary;
    Double amount;

    WithdrawalService withdrawalService = WithdrawalService.getInstance();
    DepositService depositService = DepositService.getInstance();


    public static TransferService getInstance() {
        return _instance;
    }

    private static TransferService _instance = InitInstance();

    private static TransferService InitInstance() {
        return new TransferService();
    }


    public TransferService(

    ){
    }


    @Override
    public TransferService transfer(Transfer transferParams){

        this.withdrawalService.withdrawAmount(transferParams.getSourceAccount(),transferParams.getWithdrawal());
        this.depositService.depositAmount(transferParams.getBeneficiaryAccount(),transferParams.getDeposit());
        return this;
    }




}
