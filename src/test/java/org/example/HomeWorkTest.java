package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    private MorseTranslator translator;

    @BeforeEach
    public void setUp() {
        translator = new HomeWork();
    }

    @Test
    public void testEncodeSingleWord() {
        String input = "SOS";
        String expectedOutput = "... --- ...";
        assertEquals(expectedOutput, translator.encode(input));
    }

    @Test
    public void testEncodeMultipleWords() {
        String input = "HELLO WORLD";
        String expectedOutput = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";
        assertEquals(expectedOutput, translator.encode(input));
    }

    @Test
    public void testDecodeSingleWord() {
        String input = "... --- ...";
        String expectedOutput = "SOS";
        assertEquals(expectedOutput, translator.decode(input));
    }

    @Test
    public void testDecodeMultipleWords() {
        String input = ".... . .-.. .-.. --- / .-- --- .-. .-.. -..";
        String expectedOutput = "HELLO WORLD";
        assertEquals(expectedOutput, translator.decode(input));
    }

    @Test
    public void testEncodeAndDecode() {
        String originalText = "TESTING MORSE CODE";
        String encoded = translator.encode(originalText);
        String decoded = translator.decode(encoded);
        assertEquals(originalText, decoded);
    }

    @Test
    public void testEncodeEmptyString() {
        String input = "";
        String expectedOutput = "";
        assertEquals(expectedOutput, translator.encode(input));
    }

    @Test
    public void testDecodeEmptyString() {
        String input = "";
        String expectedOutput = "";
        assertEquals(expectedOutput, translator.decode(input));
    }
}