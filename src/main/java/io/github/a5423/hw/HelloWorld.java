package io.github.a5423.hw;

import java.io.PrintStream;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloWorld {

    public static final String HELLO_WORLD_KEY = "hello.world";

    private final ResourceBundle messages;
    private final PrintStream out;

    public HelloWorld(String bandleName, Locale locale, PrintStream out) {
        this.messages = ResourceBundle.getBundle(bandleName, locale);
        this.out = out;
    }

    public static void main(String... args) {
        new HelloWorld("Messages", Locale.getDefault(), System.out).sendMessage();
    }

    public void sendMessage() {
        var message = messages.getString(HELLO_WORLD_KEY);
        out.println(message);
    }

}
