package banker.Controller.Services.WithdrawalService;

import banker.Bloc.Account.Account;
import banker.Bloc.Account.Withdrawal;
import banker.Bloc.Error.*;
import banker.Bloc.Wrapper.Constants;
import banker.Bloc.Wrapper.printer;

public class WithdrawalService {


    private Account account;
    private Double amount;


    public WithdrawalService(Account account, Double amount) {
        this.account = account;
        this.amount = amount;
    }

    public WithdrawalService withdrawAmount(){

        printer.print("Withdrawing to ", account.getAccountId());


        this.account.getWithdrawals()
                .add(new Withdrawal(
                        this.account.getAccountId(),
                        this.amount
                ));
        System.out.println(
                String.format("Amount Withdrawn Successfully to %s",this.account.getAccountId())
        );
        return this;
    }

    public WithdrawalService canWithdraw() throws Exception {
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

    public WithdrawalService canTransfer() throws Exception {
        if(this.amount < Constants.MIN_WITHDRAWAL){
            throw new MinWithdrawalAmountException();
        }
        if(this.amount>Constants.MAX_WITHDRAWAL){
            throw new MaxWithdrawalAmountException();
        }
        if((this.account.getBalance() - this.amount)<Constants.MIN_BALANCE){
            throw new MinimumAccountBalanceException(this.account.getBalance());
        }
//        if(!this.account.canWithdraw()){
//            throw new MaximumWithdrawLimitPerDayExceeded();
//        }
        return this;
    }



}
