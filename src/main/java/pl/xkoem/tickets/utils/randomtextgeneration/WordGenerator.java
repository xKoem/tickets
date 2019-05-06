package pl.xkoem.tickets.utils.randomtextgeneration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordGenerator {

    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    String generateWord(int worldLength) {
        return Stream.generate(() -> (int) (Math.random() * LETTERS.length()))
                .map(LETTERS::charAt)
                .limit(worldLength)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
