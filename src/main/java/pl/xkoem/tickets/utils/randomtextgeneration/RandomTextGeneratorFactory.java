package pl.xkoem.tickets.utils.randomtextgeneration;

import org.springframework.stereotype.Component;

@Component
public class RandomTextGeneratorFactory {

    public RandomTextGenerator getRandomTextGenerator(RandomTextGeneratorType randomTextGeneratorType) {
        switch (randomTextGeneratorType) {
            case NAME_GENERATOR:
                return new NameGenerator(new WordGenerator());
            case DESCRIPTION_GENERATOR:
                return new DescriptionGenerator(new WordGenerator());
            case PRICE_GENERATOR:
                return new PriceGenerator();
            case KEY_GENERATOR:
                return new KeyGenerator(new WordGenerator());
            default:
                throw new IllegalArgumentException();

        }
    }
}
