package banker.Bloc.Wrapper;

public enum Command {

    CREATE,

    DEPOSIT,

    WITHDRAW,

    BALANCE,

    VIEW,

    TRANSFER;


    @Override
    public String toString() {
        return super.name();
    }
}
