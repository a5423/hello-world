package io.github.a5423.hw;

import java.io.PrintStream;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Output of the greeting "Hello world" depending on the locale used
 */
public class HelloWorld {

    /**
     * Message key
     */
    public static final String HELLO_WORLD_KEY = "hello.world";

    /**
     * @param args required parameters but unused.
     */
    public static void main(String... args) {
        var config = new MessageConfig("Messages", Locale.getDefault());
        new HelloWorld(config, System.out).sendMessage();
    }

    private final ResourceBundle messages;
    private final PrintStream out;

    /**
     * @param config message configuration
     * @param out print stream for message
     */
    public HelloWorld(MessageConfig config, PrintStream out) {
        this.messages = ResourceBundle.getBundle(config.bandleName(), config.locale());
        this.out = out;
    }

    /**
     * Send message
     */
    public void sendMessage() {
        var message = messages.getString(HELLO_WORLD_KEY);
        out.println(message);
    }

}
