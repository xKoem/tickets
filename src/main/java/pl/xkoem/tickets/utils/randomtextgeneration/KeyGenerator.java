package pl.xkoem.tickets.utils.randomtextgeneration;

public class KeyGenerator implements RandomTextGenerator {

    private final WordGenerator wordGenerator;

    KeyGenerator(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
    }

    @Override
    public String provideText() {
        return wordGenerator.generateWord(20);
    }
}
