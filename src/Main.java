public class Main {

    public static void main(String[] args) {

        Loggy.error("ERROR!!!");
        Loggy.warning("Warning present");
        Loggy.info("Info!!!!");
        Loggy.notice("Notice!!!");


        Loggy.init("test.log", LogLevel.ERROR);
        Loggy.warning("Warning ne doit pas apparaitre");
//        Loggy.init("test.log", LogLevel.INFO);
        Loggy.setLogLevel(LogLevel.INFO);
        Loggy.warning("Warning d'info");
        // Loggy.info("Je logge n'imp");
        //Loggy.info("Deuxieme ligne");
        Loggy.setLogLevel(LogLevel.DEBUG);
        Loggy.debug("World test.log");
        //System.out.println(ConsoleColors.RED + "ERROR " + ConsoleColors.RESET + "Arghhh !!");

//        System.out.println();
//        System.out.println();
//        LogLevel.tests();
    }


}
