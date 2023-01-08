package com.bankapp;


import com.bankapp.Bloc.Account.*;
import com.bankapp.Bloc.Error.AccountNotFound;
import com.bankapp.Bloc.Error.FixedAccountDepositException;
import com.bankapp.Bloc.Reader.IReader;
import com.bankapp.Bloc.Wrapper.Command;
import com.bankapp.Bloc.Wrapper.printer;
import com.bankapp.Services.DepositService.DepositService;
import com.bankapp.Services.DepositService.IDepositService;
import com.bankapp.Services.TransferService.ITransferService;
import com.bankapp.Services.TransferService.TransferService;
import com.bankapp.Services.WithdrawalService.IWithdrawalService;
import com.bankapp.Services.WithdrawalService.WithdrawalService;

import java.util.*;

/**
 * Primary Class
 *
 * Singleton Class
 * Ensures only one copy of object exists during runtime
 * Significant to avoid redundancy of object.
 */

public class Application {


    /**
     * Initialised only during start of execution. I.E prior to program execution
     */
    private static Application application = InitApplication();


    private IWithdrawalService withdrawalService = WithdrawalService.getInstance();

    private IDepositService depositService = DepositService.getInstance();

    private ITransferService transferService = TransferService.getInstance();





    /**
     * Will be storing the account information of users
     * during the runtime, as storage mechanism is not used
     */
    private HashMap<Integer, Account> accountList = new HashMap<>();
    private IReader reader;



    public static Application getApplication(){
        return application;
    }

    /**
     * Private Constructor ensures there are no copies of object creation
     */
    private Application(){
    }

    private static Application InitApplication(){
        System.out.println("Application Initialised");
        return new Application();
    }


    public void execute(IReader reader){

        this.reader = reader;
        while(this.reader.hasNextLine()){
            this.run();
        }

        printer.print("Application Out");

    }

    private void run(){
        try {
            Command command = this.reader.nextCommand();
            switch (command){
                case CREATE:
                    this.CreateAccount();
                    break;

                case DEPOSIT:
                    this.DepositAction();
                    break;

                case BALANCE:
                    this.ViewAccountStatement();
                    break;

                case TRANSFER:
                    this.TransferAction();
                    break;

                case WITHDRAW:
                    this.WithdrawAction();
                    break;

                case VIEW:
                    this.ViewAccountStatement();
                    break;

                case FIXED:
                    this.CreateNewFixedAccount();
                    break;

                default:

                    break;
            }
        }
        catch (IllegalArgumentException ex){
            printer.print("Invalid Input. Please try again");
        }
        catch (Exception e) {
            printer.print(e.getMessage());
            return;
        }
    }

    /**
     * Creates New Account
     */
    private void CreateAccount(){
        printer.print("New User Account");

        printer.print("Enter your full name : ");

        String fullName;
        do{
           fullName = this.reader.nextLine();
        }while (fullName.isBlank());

        Account newAccount = new Account(this.getNextAccountID(),fullName);

        this.accountList.put(newAccount.getAccountId(),newAccount);
        printer.print(String
                .format("Account Id : %s , Username : %s",
                        newAccount.getAccountId(),
                        newAccount.getFullName()
                        )
        );

    }

    public void CreateNewFixedAccount() throws FixedAccountDepositException {
        FixedAccount fixedAccount = this.reader.nextFixedAccount();

        fixedAccount.depositAmount();

    }



    private DepositService DepositAction() throws Exception {

        Deposit deposit = this.reader.nextDeposit();


        printer.print(deposit);

//        Account depositAccount = this.getAccount(deposit.getAccountId());

        deposit.canDeposit();

        return this.depositService
                .depositAmount(deposit.getAccount(),deposit);


    }


    private WithdrawalService WithdrawAction() throws Exception{

        Withdrawal withdrawal = this.reader.nextWithdrawal();

        printer.print(withdrawal);

//        Account withdrawalAccount = this.getAccount(withdrawal.getAccountId());

        withdrawal.canWithdraw();

        return this.withdrawalService
                .withdrawAmount(withdrawal.getAccount(),withdrawal);
    }

    private TransferService TransferAction() throws Exception{

        Transfer transfer = this.reader.nextTransfer();

        printer.print(transfer);

//        Account fromAccount = this.getAccount(transfer.getSourceAccount().getAccountId());
//        Account toAccount = this.getAccount(transfer.getBeneficiaryAccount().getAccountId());
//
//        fromAccount.ViewStatement();
//        toAccount.ViewStatement();

        transfer.canTransfer();

        return this.transferService.transfer(transfer);


    }




    private void ViewAccountStatement() throws AccountNotFound {
        Integer accountId = this.reader.nextInt();

        Account depositAccount = this.getAccount(accountId);

        depositAccount.ViewStatement();

    }


    public Account getAccount(Integer accountId) {
        if(!accountList.containsKey(accountId)){
            try {
                throw new AccountNotFound();
            } catch (AccountNotFound e) {
                e.printStackTrace();
            }
        }
        return this.accountList.get(accountId);
    }


    public Integer getNextAccountID(){
        return (this.accountList.size() + 1000 );
    }

    public HashMap<Integer, Account> getAccountList() {
        return accountList;
    }
}
