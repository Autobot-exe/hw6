package org.example;


import java.util.HashMap;
import java.util.Map;

public class HomeWork implements MorseTranslator {

    private static final Map<Character, String> morseCodeMap = new HashMap<>();
    private static final Map<String, Character> reverseMorseCodeMap = new HashMap<>();

    static {
        // Инициализация кодов Морзе
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i < letters.length; i++) {
            morseCodeMap.put(letters[i].charAt(0), morseCodes[i]);
            reverseMorseCodeMap.put(morseCodes[i], letters[i].charAt(0));
        }
    }

    @Override
    public String decode(String morseCode) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = morseCode.split(" / ");

        for (String word : words) {
            String[] symbols = word.split(" ");
            for (String symbol : symbols) {
                Character letter = reverseMorseCodeMap.get(symbol);
                if (letter != null) {
                    decodedMessage.append(letter);
                }
            }
            decodedMessage.append(" ");
        }

        return decodedMessage.toString().trim();
    }

    @Override
    public String encode(String source) {
        StringBuilder encodedMessage = new StringBuilder();
        source = source.toUpperCase();

        for (char c : source.toCharArray()) {
            if (c == ' ') {
                encodedMessage.append("/ ");
            } else {
                String morseCode = morseCodeMap.get(c);
                if (morseCode != null) {
                    encodedMessage.append(morseCode).append(" ");
                }
            }
        }

        return encodedMessage.toString().trim();
    }
}
