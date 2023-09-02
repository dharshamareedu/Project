import java.util.logging.Logger;

public class App {
    // Create a logger instance
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        // Log a message at INFO level
        logger.log("This is Jenkins :)");

        // You can log at different levels (e.g., INFO, WARNING, ERROR) and format messages as needed.
    }
}
