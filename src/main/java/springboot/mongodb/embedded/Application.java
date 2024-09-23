package springboot.mongodb.embedded;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point class for Application.
 */
@SpringBootApplication
public class Application {
    /**
     * Main entry point method.
     *
     * @param args input arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
