package banker.Bloc.Error;

public class MaximumAccountBalanceReached extends Exception{

    public MaximumAccountBalanceReached(Double balance){
        super("Maximum Account Balance Reached.  Current Balance : " + balance);
    }
}
