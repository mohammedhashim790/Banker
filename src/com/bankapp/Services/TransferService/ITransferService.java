package com.bankapp.Services.TransferService;

import com.bankapp.Bloc.Account.Transfer;

public interface ITransferService {

    TransferService transfer(Transfer transferParams);
}
