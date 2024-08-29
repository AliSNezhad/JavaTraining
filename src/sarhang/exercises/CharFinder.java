package sarhang.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char firstNonRepeatingCharacter (String str) {
        Map<Character, Integer> charactersMap = new HashMap<>();
        char[] characters = str.toLowerCase().toCharArray();

        for (char ch : characters) {
            int count = charactersMap.containsKey(ch) ? charactersMap.get(ch) : 0;
            charactersMap.put(ch, ++count);
        }

        for (char c : characters) {
            if (charactersMap.get(c) == 1) {
                return c;
            }
        }
        return Character.MIN_VALUE;
    }

    public char firstRepeatingCharacter (String str) {
        Set<Character> characterSet = new HashSet<>();
        char[] characters = str.toLowerCase().toCharArray();

        for (char ch : characters) {
            if (characterSet.contains(ch)) {
                return ch;
            }
            characterSet.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
