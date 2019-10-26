import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Solution {

    static Optional<Character> findDoubled(List<Character> characters) {
        if (characters.size() == 0) return Optional.empty();
        char ch = characters.get(0);

        for (int i = 1; i < characters.size(); i++) {
            if (ch == characters.get(i)) return Optional.of(ch);
            ch = characters.get(i);
        }
        return Optional.empty();
    }

    static HashMap<Character, Integer> genCharactersCountMap(List<Character> characters) {
        Set<Character> characterSet = new HashSet<>(characters);
        HashMap<Character, Integer> characterCount = new HashMap<>();
        for (Character character : characters) {
            if (characterCount.containsKey(character)) {
                characterCount.put(character, characterCount.get(character) + 1);
            } else {
                characterCount.put(character, 1);
            }
        }
        return characterCount;
    }

    static int alternate(String s) {
        List<Character> characters = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Set<Character> uniqueCharacters;
        List<Queue<Character>> allPermutations;
        int uniqueCharactersSize;
        int maxSize;

        Optional<Character> toRemove = findDoubled(characters);
        while (toRemove.isPresent()) {
            while (characters.contains(toRemove.get())) {
                characters.remove(toRemove.get());
            }
            toRemove = findDoubled(characters);
        }

        maxSize = characters.size();

        uniqueCharacters = new HashSet<>(characters);
        uniqueCharactersSize = uniqueCharacters.size();
        if (uniqueCharactersSize == 2) return maxSize;
        if (uniqueCharactersSize < 2) return 0;

        allPermutations = genAllPermutations(uniqueCharacters);

        return maxSize;

    }

    private static long factorialUsingRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorialUsingRecursion(n - 1);
    }

    private static List<Queue<Character>> genAllPermutations(Set<Character> uniqueCharacters) {
        Set<Queue<Character>> allPermutations = new HashSet<>();
        long counter = factorialUsingRecursion(uniqueCharacters.size());
        while (counter != 0) {

        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        long[] arr = {1, 2, 3, 4, 5};
//        long result = gradingStudents(arr, 8);
//        List<Integer> list = Arrays.asList(73, 67, 38, 33);
//        List<Integer> result = gradingStudents(list);

        String str = "beabeefeab";
        int result = alternate(str);
        System.out.println(result);
    }
}
