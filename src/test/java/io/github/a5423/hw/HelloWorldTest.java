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
    void testEnglishMessage() {
        var helloWorld = new HelloWorld("Messages", Locale.ENGLISH, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("Hello World!")
        );
    }

    @Test
    void testChineseMessage() {
        var helloWorld = new HelloWorld("Messages", Locale.CHINA, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("你好，世界！")
        );
    }

    @Test
    void testUnknownLocaleFallbackToDefault() {
        var unknownLocale = new Locale("xx");
        var helloWorld = new HelloWorld("Messages", unknownLocale, printStream);
        helloWorld.sendMessage();
        MatcherAssert.assertThat(
                outputStream.toString(),
                CoreMatchers.containsString("Hello World!")
        );
    }

}
