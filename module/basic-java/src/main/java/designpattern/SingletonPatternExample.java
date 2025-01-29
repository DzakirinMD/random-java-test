package designpattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 🎯 TL;DR
 * 🔹 Singleton ensures only ONE instance of a class exists
 * 🔹 Use it for shared resources like databases, configuration, logging
 * 🔹 Prevents unnecessary object creation
 *
 * The Singleton Pattern is like having ONE President, and you can’t create a new one!
 */
// 1️⃣ Singleton Logger Class
class Logger {
    private static Logger instance;
    private DateTimeFormatter formatter;

    // 🔒 Private constructor (prevents direct instantiation)
    private Logger() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    // 🏗 Public method to get the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // 📜 Method to log messages
    public void log(String message) {
        System.out.println(LocalDateTime.now().format(formatter) + " - " + message);
    }
}

// 2️⃣ Client Code
public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started"); // Logs a message

        Logger logger2 = Logger.getInstance();
        logger2.log("User logged in"); // Logs another message

        // Checking if both instances are the same
        System.out.println(logger1 == logger2); // Output: true
    }
}
