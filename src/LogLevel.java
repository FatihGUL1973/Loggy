

public enum LogLevel {

    NONE, ERROR, WARNING, INFO, NOTICE, DEBUG;
/*
    NONE(0), ERROR(1), WARNING(2), INFO(3), NOTICE(4), DEBUG(5);

    private final int value;

    private LogLevel(int valeur) {
        this.value = valeur;
    }

    public int getValue() {
        return this.value;
    }
*/

    public static void tests(){
        LogLevel.test(LogLevel.NONE, LogLevel.NONE);
        LogLevel.test(LogLevel.NONE, LogLevel.ERROR);
        LogLevel.test(LogLevel.NONE, LogLevel.WARNING);
        LogLevel.test(LogLevel.NONE, LogLevel.INFO);
        LogLevel.test(LogLevel.NONE, LogLevel.NOTICE);
        LogLevel.test(LogLevel.NONE, LogLevel.DEBUG);
    }
    public static void test(LogLevel a, LogLevel b){
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.compareTo(b));
    }
}
