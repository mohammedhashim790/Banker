package banker.Bloc.Wrapper;

public class printer {

    public static void print(Object title){
        System.out.println(title.toString());
    }

    public static void print(Object title,Object message){
        System.out.println(String.format("%s %s", title.toString(),message.toString()));
    }


    public static void error(Object title){
        System.err.println(title.toString());
    }
}
