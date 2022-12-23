package banker.Bloc.Account;

import banker.Bloc.Wrapper.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    private String fullName;

    private Integer accountId;

    private Double balance = 0.0;

    private List<Withdrawal> withdrawals = new ArrayList<Withdrawal>(){
        @Override
        public boolean add(Withdrawal withdrawal) {
            canWithdraw();

            balance-=withdrawal.getAmount();

            return super.add(withdrawal);
        }
    };

    private List<Deposit> deposits = new ArrayList<Deposit>(){
        @Override
        public boolean add(Deposit deposit) {
            canDeposit();

            balance+=deposit.getAmount();

            return super.add(deposit);
        }
    };


    /**
     * Create Account
     * @param fullName
     * @param accountId
     */
    public Account(String fullName, Integer accountId) {
        this.fullName = fullName;
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Withdrawal> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<Withdrawal> withdrawals) {
        this.withdrawals = withdrawals;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    /**
     * Checks whether the account can deposit the amount
     * Checks for current Day and the last day of deposit && number of deposit made
     * in a day
     * @return boolean
     */
    public boolean canDeposit(){

        Date lastDate = (this.deposits.isEmpty()?new Date():this.deposits.get(this.deposits.size() - 1).getCreatedAt());

        boolean today = lastDate.getDay() == (new Date().getDay());

        return this.getDeposits().size()<Constants.MAX_DEPOSITS_LIMIT && today;
    }


    /**
     * Checks whether the account can Withdraw the amount
     * Checks for current Day and the last day of Withdraw && number of Withdar made
     * in a day
     * @return boolean
     */
    public boolean canWithdraw() {

        Date lastDate = (this.withdrawals.isEmpty()?new Date():this.withdrawals.get(this.withdrawals.size() - 1).getCreatedAt());

        boolean today = lastDate.getDay() == (new Date().getDay());

        return this.getWithdrawals().size()< Constants.MAX_WITHDRAW_LIMIT && today;
    }





    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    @Override
    public String toString() {
        return "Account{" +
                "fullName='" + fullName + '\'' +
                ", accountId=" + accountId +
                ", balance=" + balance +
                ", withdrawals=" + withdrawals +
                ", deposits=" + deposits +
                '}';
    }

    public void ViewStatement(){
        System.out.println("\n\nfullName\t\t:'" + fullName + "\'\n" +
                "accountId\t\t:" + accountId + "\n" +
                "balance\t\t:" + balance + "\n" +
                "withdrawals\t\t:" + withdrawals + "\n" +
                "deposits\t\t:" + deposits + "\n\n");
    }



    private void newWithdrawal(){
        Withdrawal withdrawal = new Withdrawal();
    }



}
