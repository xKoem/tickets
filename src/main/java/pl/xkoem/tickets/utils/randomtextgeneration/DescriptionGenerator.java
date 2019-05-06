package pl.xkoem.tickets.utils.randomtextgeneration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DescriptionGenerator implements RandomTextGenerator {

    private final WordGenerator wordGenerator;

    DescriptionGenerator(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
    }

    @Override
    public String provideText() {
        return Stream.generate(() -> (int) (Math.random() * 20))
                .map(wordGenerator::generateWord)
                .map(x -> x + " ")
                .limit((int) (Math.random() * 20))
                .collect(Collectors.joining());
    }
}
