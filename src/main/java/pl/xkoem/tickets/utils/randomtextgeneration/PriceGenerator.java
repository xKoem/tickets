package pl.xkoem.tickets.utils.randomtextgeneration;

public class PriceGenerator implements RandomTextGenerator {

    PriceGenerator() {
    }

    @Override
    public String provideText() {
        return (int) (Math.random() * 200) + "." + (int) (Math.random() * 100);
    }
}
