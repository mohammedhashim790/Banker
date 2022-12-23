package banker.Bloc.Error;

public class MaxWithdrawalAmountException extends Exception {
    public MaxWithdrawalAmountException() {
        super("Maximum Deposit Amount Exceeded");
    }
}
