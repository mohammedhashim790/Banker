package banker.Bloc.Error;

import banker.Bloc.Wrapper.Constants;

public class MaximumDepositLimitPerDayExceeded extends Exception {

    public MaximumDepositLimitPerDayExceeded() {
//        super("Maximum Deposit Limit per Day Exceeded");
        super(String.format("Only %d deposits are allowed in a day", Constants.MAX_DEPOSITS_LIMIT));

    }

}
