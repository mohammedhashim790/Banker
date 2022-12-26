package banker.Controller.Services.DepositService;

import banker.Bloc.Account.Account;
import banker.Bloc.Account.Deposit;
import banker.Bloc.Error.MaximumDepositLimitPerDayExceeded;
import banker.Bloc.Error.MaxDepositAmountException;
import banker.Bloc.Error.MaximumAccountBalanceReached;
import banker.Bloc.Error.MinDepositAmountException;
import banker.Bloc.Wrapper.Constants;
import banker.Bloc.Wrapper.printer;

public class DepositService {

    private Account account;
    private Double amount;

    public DepositService(Account account, Double amount) {
        this.account = account;
        this.amount = amount;
    }

    public DepositService depositAmount(){

        printer.print("Depositing to ", account.getAccountId());


        this.account.getDeposits()
                .add(new Deposit(
                        this.account.getAccountId(),
                        this.amount
                ));
        System.out.println(
                String.format("Amount Deposited Successfully to %s",this.account.getAccountId())
        );
        return this;
    }

    public DepositService canDeposit() throws Exception {
        if(this.amount < Constants.MIN_DEPOSITS){
            throw new MinDepositAmountException();
        }
        if(this.amount>Constants.MAX_DEPOSITS){
            throw new MaxDepositAmountException();
        }
        if((this.account.getBalance() + this.amount)>Constants.MAX_BALANCE){
            throw new MaximumAccountBalanceReached(this.account.getBalance());
        }
        if(!this.account.canDeposit()){
            throw new MaximumDepositLimitPerDayExceeded();
        }
        return this;
    }

    public DepositService canReceive() throws Exception {
        if(this.amount < Constants.MIN_DEPOSITS){
            throw new MinDepositAmountException();
        }
        if(this.amount>Constants.MAX_DEPOSITS){
            throw new MaxDepositAmountException();
        }
        if((this.account.getBalance() + this.amount)>Constants.MAX_BALANCE){
            throw new MaximumAccountBalanceReached(this.account.getBalance());
        }
        return this;
    }



}
