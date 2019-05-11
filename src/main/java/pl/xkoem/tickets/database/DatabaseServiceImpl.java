package pl.xkoem.tickets.database;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.City;
import pl.xkoem.tickets.models.Ticket;
import pl.xkoem.tickets.models.TicketCode;
import pl.xkoem.tickets.models.TicketType;
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

        TicketType standardTicket = TicketType.valueOf("standard");
        TicketType halfPriceTicket = TicketType.valueOf("half-price");
        ticketTypeRepository.saveAndFlush(standardTicket);
        ticketTypeRepository.saveAndFlush(halfPriceTicket);
        List<TicketType> ticketTypes = Arrays.asList(standardTicket, halfPriceTicket);

        City krakow = City.valueOf("Krakow");
        City warszawa = City.valueOf("Warszawa");
        City gdansk = City.valueOf("Gdansk");
        List<City> cities = Arrays.asList(krakow, warszawa, gdansk);

        cityRepository.saveAndFlush(krakow);
        cityRepository.saveAndFlush(warszawa);
        cityRepository.saveAndFlush(gdansk);

        List<Ticket> tickets = Stream.generate(() -> Ticket.newBuilder()
                .setName(nameGenerator.provideText())
                .setDescription(descriptionGenerator.provideText())
                .setPrice(new BigDecimal(priceGenerator.provideText()))
                .setTicketType(ticketTypes.get((int) (Math.random() * ticketTypes.size())))
                .setCity(cities.get((int) (Math.random() * cities.size())))
                .build())
                .limit(30)
                .collect(Collectors.toList());

        tickets.forEach(ticketsRepository::saveAndFlush);

        tickets.forEach(this::generateKeys);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void generateKeys(Ticket ticket) {
        Stream.generate(keyGenerator::provideText)
                .limit(30)
                .map(x -> TicketCode.newBuilder()
                        .setTicket(ticket)
                        .setKey(x)
                        .build())
                .forEach(ticketCodeRepository::saveAndFlush);
    }
}
