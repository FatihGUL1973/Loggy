import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loggy {
    private static FileOutputStream logWriter;
    private static String path = "loggy.log";

    // DEFINE A LOG LEVEL (WITH AN ENUM)
    private static LogLevel loglevel = LogLevel.DEBUG;

    public static void init() {
        try {
            logWriter = new FileOutputStream(Loggy.path, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void init(String path) {
        Loggy.path = path;
        Loggy.init();
    }

    public static void init(String path, LogLevel loglevel) {
        Loggy.path = path;
        Loggy.loglevel = loglevel;
        Loggy.init();
    }

    public static void init(LogLevel loglevel) {
        Loggy.loglevel = loglevel;
        Loggy.init();
    }

    public static void setLogLevel(LogLevel loglevel) {
        Loggy.loglevel = loglevel;
    }

    private static void write(String msg) {
        try {
            if (Loggy.logWriter == null) {
                Loggy.init();
            }

            // Add DATETIME
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


            logWriter.write('[');
            logWriter.write(now.format(dtf).getBytes(StandardCharsets.UTF_8));
            logWriter.write(']');
            logWriter.write(' ');
            logWriter.write(msg.getBytes(StandardCharsets.UTF_8));
            logWriter.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void error(String msg) {
        if (Loggy.loglevel.compareTo(LogLevel.ERROR) >= 0) {
            Loggy.write("[ERROR] " + msg);
        }
    }

    public static void warning(String msg) {
        if (Loggy.loglevel.compareTo(LogLevel.WARNING) >= 0) {
            Loggy.write("[WARNING] " + msg);
        }
    }

    public static void info(String msg) {
        if (Loggy.loglevel.compareTo(LogLevel.INFO) >= 0) {
            Loggy.write("[INFO] " + msg);
        }
    }

    public static void notice (String msg) {
        if (Loggy.loglevel.compareTo(LogLevel.NOTICE) >= 0) {
            Loggy.write("[NOTICE] " + msg);
        }
    }

    public static void debug (String msg) {
        if (Loggy.loglevel.compareTo(LogLevel.DEBUG) >= 0) {
            Loggy.write("[DEBUG] " + msg);
        }
    }
}
