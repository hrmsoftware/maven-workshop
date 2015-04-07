package se.hrmsoftware.labb;

/**
 * A class that greets using the configured greeting prefix.
 */
public class HelloWorld {

    private final String greetingPrefix;

    public HelloWorld(String greetingPrefix) {
        this.greetingPrefix = greetingPrefix;
    }

    /**
     * Default constructor - the greeting prefix will be 'Hello, '.
     */
    public HelloWorld() {
        this("Hello, ");
    }

    /**
     * @return a greeting.
     */
    public String greet(String name) {
        return greetingPrefix + name;
    }
}
