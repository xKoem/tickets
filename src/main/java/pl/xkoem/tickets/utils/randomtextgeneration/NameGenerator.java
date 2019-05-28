package pl.xkoem.tickets.utils.randomtextgeneration;

public class NameGenerator implements RandomTextGenerator {

    private final WordGenerator wordGenerator;

    NameGenerator(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
    }

    @Override
    public String provideText() {
        return wordGenerator.generateWord(5);
    }
}
