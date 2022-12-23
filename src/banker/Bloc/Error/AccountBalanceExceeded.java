package banker.Bloc.Error;

public class AccountBalanceExceeded extends Exception {
    AccountBalanceExceeded() {
        super("Maximum Account Balance Exception");
    }
}
