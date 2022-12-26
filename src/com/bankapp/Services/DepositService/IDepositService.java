package com.bankapp.Services.DepositService;

import com.bankapp.Bloc.Account.Account;
import com.bankapp.Bloc.Account.Deposit;

public interface IDepositService {
    DepositService depositAmount(
            Account account,
            Deposit depositAccount);
}
