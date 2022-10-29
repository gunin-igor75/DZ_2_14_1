package pro.sky;

public class Value {
    public static String CAT = "Murka";
    public static String DOG = "Bobik";
    public static String MOUSE = "Jerry";
    public static int ZERO = 0;
    public static int ONE = 1;
    public static int TWO = 2;
    public static int SIX = 6;
    public static int MINUS_ONE = -1;
    public static String[] array = {CAT, DOG};

    public static StringListImp LIST = new StringListImp(5);

    static {
        LIST.add(CAT);
        LIST.add(DOG);
    }
}
