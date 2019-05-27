package pl.xkoem.tickets.database;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.CityEntity;
import pl.xkoem.tickets.models.TicketCodeEntity;
import pl.xkoem.tickets.models.TicketEntity;
import pl.xkoem.tickets.models.TicketTypeEntity;
import pl.xkoem.tickets.tickets.repository.CityRepository;
import pl.xkoem.tickets.tickets.repository.TicketCodeRepository;
import pl.xkoem.tickets.tickets.repository.TicketTypeRepository;
import pl.xkoem.tickets.tickets.repository.TicketsRepository;
import pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGenerator;
import pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGeneratorFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGeneratorType.*;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private final CityRepository cityRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final TicketsRepository ticketsRepository;
    private final TicketCodeRepository ticketCodeRepository;

    private final RandomTextGenerator nameGenerator;
    private final RandomTextGenerator descriptionGenerator;
    private final RandomTextGenerator priceGenerator;
    private final RandomTextGenerator keyGenerator;

    public DatabaseServiceImpl(TicketsRepository ticketsRepository, CityRepository cityRepository, TicketTypeRepository ticketTypeRepository, TicketCodeRepository ticketCodeRepository, RandomTextGeneratorFactory randomTextGeneratorFactory) {
        this.ticketsRepository = ticketsRepository;
        this.cityRepository = cityRepository;
        this.ticketTypeRepository = ticketTypeRepository;
        this.ticketCodeRepository = ticketCodeRepository;

        nameGenerator = randomTextGeneratorFactory.getRandomTextGenerator(NAME_GENERATOR);
        descriptionGenerator = randomTextGeneratorFactory.getRandomTextGenerator(DESCRIPTION_GENERATOR);
        priceGenerator = randomTextGeneratorFactory.getRandomTextGenerator(PRICE_GENERATOR);
        keyGenerator = randomTextGeneratorFactory.getRandomTextGenerator(KEY_GENERATOR);

    }

    @Override
    public ResponseEntity populateDatabase() {

        TicketTypeEntity standardTicket = TicketTypeEntity.valueOf("standard");
        TicketTypeEntity halfPriceTicket = TicketTypeEntity.valueOf("half-price");
        ticketTypeRepository.saveAndFlush(standardTicket);
        ticketTypeRepository.saveAndFlush(halfPriceTicket);
        List<TicketTypeEntity> ticketTypeEntities = Arrays.asList(standardTicket, halfPriceTicket);

        CityEntity krakow = CityEntity.valueOf("Krakow");
        CityEntity warszawa = CityEntity.valueOf("Warszawa");
        CityEntity gdansk = CityEntity.valueOf("Gdansk");
        List<CityEntity> cities = Arrays.asList(krakow, warszawa, gdansk);

        cityRepository.saveAndFlush(krakow);
        cityRepository.saveAndFlush(warszawa);
        cityRepository.saveAndFlush(gdansk);

        List<TicketEntity> ticketEntities = Stream.generate(() -> TicketEntity.newBuilder()
                .setName(nameGenerator.provideText())
                .setDescription(descriptionGenerator.provideText())
                .setPrice(new BigDecimal(priceGenerator.provideText()))
                .setTicketTypeEntity(ticketTypeEntities.get((int) (Math.random() * ticketTypeEntities.size())))
                .setCityEntity(cities.get((int) (Math.random() * cities.size())))
                .build())
                .limit(30)
                .collect(Collectors.toList());

        ticketEntities.forEach(ticketsRepository::saveAndFlush);

        ticketEntities.forEach(this::generateKeys);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void generateKeys(TicketEntity ticketEntity) {
        Stream.generate(keyGenerator::provideText)
                .limit(30)
                .map(x -> TicketCodeEntity.newBuilder()
                        .setTicketEntity(ticketEntity)
                        .setKey(x)
                        .build())
                .forEach(ticketCodeRepository::saveAndFlush);
    }
}
