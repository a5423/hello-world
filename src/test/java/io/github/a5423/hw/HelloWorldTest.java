package io.github.a5423.hw;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

public class HelloWorldTest {

    ByteArrayOutputStream outputStream;
    PrintStream printStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
    }

    @Test
    void testEnMessage() {
        var config = new MessageConfig("Messages", Locale.ENGLISH);
        var helloWorld = new HelloWorld(config, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("Hello World!")
        );
    }

    @Test
    void testChMessage() {
        var config = new MessageConfig("Messages", Locale.CHINA);
        var helloWorld = new HelloWorld(config, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("你好，世界！")
        );
    }

    @Test
    void testEsMessage() {
        var config = new MessageConfig("Messages", new Locale("es"));
        var helloWorld = new HelloWorld(config, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("Hola Mundo!")
        );
    }

    @Test
    void testMxMessage() {
        var config = new MessageConfig("Messages", new Locale("mx"));
        var helloWorld = new HelloWorld(config, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("Hola Mundo!")
        );
    }

    @Test
    void testHiMessage() {
        var config = new MessageConfig("Messages", new Locale("hi"));
        var helloWorld = new HelloWorld(config, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("नमस्ते दुनिया!")
        );
    }

    @Test
    void testUnknownLocaleFallbackToDefault() {
        var unknownLocale = new Locale("xx");
        var config = new MessageConfig("Messages", unknownLocale);
        var helloWorld = new HelloWorld(config, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("Hello World!")
        );
    }

}
