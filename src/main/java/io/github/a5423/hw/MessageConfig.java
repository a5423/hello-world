package io.github.a5423.hw;

import java.util.Locale;

/**
 * @param bandleName name of message bundle to use
 * @param locale environment locale
 */
public record MessageConfig(String bandleName, Locale locale) {

}
