package banker.Controller.TransferService;

import banker.Bloc.Account.Account;
import banker.Controller.DepositService.DepositService;
import banker.Controller.WithdrawalService.WithdrawalService;

public class TransferService {

    Account sourceAccount;
    Account beneficiary;
    Double amount;

    WithdrawalService withdrawalService;
    DepositService depositService;

    public TransferService(
            Account sourceAccount,
            Account beneficiary,
            Double amount
    ){
      this.sourceAccount = sourceAccount;
      this.beneficiary = beneficiary;
      this.amount = amount;
    }

    public TransferService transfer(){

        this.withdrawalService.withdrawAmount();
        this.depositService.depositAmount();
        return this;
    }

    public TransferService canTransfer() throws Exception {

//        Source Account Subtracts the balance, hence Withdraw
        this.withdrawalService = new WithdrawalService(
          this.sourceAccount,
          this.amount
        ).canWithdraw();
//        Receiver gets credited, hence deposit
        this.depositService = new DepositService(
                this.beneficiary,
                this.amount
        ).canDeposit();

        return this;
    }




}
