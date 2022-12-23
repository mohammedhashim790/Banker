package banker.Bloc.Account;

import java.util.Date;
import java.util.Random;

public abstract class Transaction {

    abstract protected void doExecute() throws Exception;


}
