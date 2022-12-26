package banker.Controller.Services.Session;


import banker.Bloc.Account.Account;
import banker.Bloc.Error.AccountNotFound;
import banker.Bloc.Wrapper.Command;
import banker.Bloc.Wrapper.printer;
import banker.Controller.Services.DepositService.DepositService;
import banker.Controller.Services.TransferService.TransferService;
import banker.Controller.Services.WithdrawalService.WithdrawalService;

import java.util.*;

/**
 * Primary Class
 *
 * Singleton Class
 * Ensures only one copy of object exists during runtime
 * Significant to avoid redundancy of object.
 */

public class Session {


    /**
     * Initialised only during start of execution. I.E prior to program execution
     */
    private static Session session = InitSession();


    /**
     * Will be storing the account information of users
     * during the runtime, as storage mechanism is not used
     */
    private List<Account> accountList = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);


    public static Session getSession(){
        return session;
    }

    /**
     * Private Constructor ensures there are no copies of object creation
     */
    private Session(){
    }

    private static Session InitSession(){
        System.out.println("Session Initialised");
        return new Session();
    }


    public void execute(){

        while(this.scanner.hasNextLine()){
            this.run();
        }

        printer.print("Session Out");

    }

    private void run(){
        String command = this.scanner.next();

        try {
            switch (Command.valueOf(command.toUpperCase())){

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

                default:

                    break;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
    }

    /**
     * Creates New Account
     */
    private void CreateAccount(){
        printer.print("New User Account");

        printer.print("Enter your full name : ");

        String fullName = this.scanner.nextLine();

        Account newAccount = new Account(fullName,this.getNextAccountID());

        this.accountList.add(new Account(fullName,this.getNextAccountID()));

        printer.print("User Created Succesfully : ");
        printer.print(String
                .format("Account Id : %s , Username : %s",
                        newAccount.getAccountId(),
                        newAccount.getFullName()
                        )
        );

    }



    private DepositService DepositAction() throws Exception {
        Integer accountId = this.scanner.nextInt();

        Double depositAmount = this.scanner.nextDouble();

        printer.print(accountId,depositAmount);

        Account depositAccount = this.getAccount(accountId);


        return new DepositService(depositAccount,depositAmount)
                .canDeposit()
                .depositAmount();


    }


    private WithdrawalService WithdrawAction() throws Exception{
        Integer accountId = this.scanner.nextInt();

        Double depositAmount = this.scanner.nextDouble();

        printer.print(accountId,depositAmount);

        Account depositAccount = this.getAccount(accountId);


        return new WithdrawalService(depositAccount,depositAmount)
                .canWithdraw()
                .withdrawAmount();
    }

    private TransferService TransferAction() throws Exception{
        Integer fromAccountId = this.scanner.nextInt();

        Integer toAccountId = this.scanner.nextInt();


        Double depositAmount = this.scanner.nextDouble();

        printer.print("fromAccountId",fromAccountId);
        printer.print("ToAccountId",toAccountId);

        Account fromAccount = this.getAccount(fromAccountId);
        Account toAccount = this.getAccount(toAccountId);

        fromAccount.ViewStatement();
        toAccount.ViewStatement();

        return new TransferService(
                fromAccount,
                toAccount,
                depositAmount).canTransfer().transfer();


    }




    private void ViewAccountStatement() throws AccountNotFound {
        Integer accountId = this.scanner.nextInt();

        Account depositAccount = this.getAccount(accountId);

        depositAccount.ViewStatement();

    }


    private Account getAccount(Integer accountId) throws AccountNotFound {
        Optional<Account> depositAccount = this.accountList.stream().filter((account -> Objects.equals(account.getAccountId(), accountId))).findFirst();

        if(depositAccount.isEmpty()){
            throw new AccountNotFound();
        }
        return depositAccount.get();
    }


    private Integer getNextAccountID(){
        return (this.accountList.size() + 1000 );
    }




}
