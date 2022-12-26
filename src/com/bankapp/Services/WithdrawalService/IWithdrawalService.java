package com.bankapp.Services.WithdrawalService;

import com.bankapp.Bloc.Account.Account;
import com.bankapp.Bloc.Account.Withdrawal;

public interface IWithdrawalService {

    WithdrawalService withdrawAmount(Account account,Withdrawal withdrawalAccount);
}
