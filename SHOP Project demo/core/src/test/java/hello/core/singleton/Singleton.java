package hello.core.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static void setInstance() {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }

}
