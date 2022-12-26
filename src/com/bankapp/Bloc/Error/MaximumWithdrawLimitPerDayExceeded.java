package com.bankapp.Bloc.Error;

import com.bankapp.Bloc.Wrapper.Constants;

public class MaximumWithdrawLimitPerDayExceeded extends Exception {

    public MaximumWithdrawLimitPerDayExceeded() {
//        super("Maximum Withdraw Limit per Day Exceeded");
        super(String.format("Only %d withdrawals are allowed in a day", Constants.MAX_WITHDRAW_LIMIT));
    }
}
