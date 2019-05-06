package pl.xkoem.tickets.database;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.City;
import pl.xkoem.tickets.models.Ticket;
import pl.xkoem.tickets.models.TicketType;
import pl.xkoem.tickets.tickets.repository.CityRepository;
import pl.xkoem.tickets.tickets.repository.TicketTypeRepository;
import pl.xkoem.tickets.tickets.repository.TicketsRepository;
import pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGenerator;
import pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGeneratorFactory;

import java.math.BigDecimal;

import static pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGeneratorType.*;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private final CityRepository cityRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final TicketsRepository ticketsRepository;
    private final RandomTextGeneratorFactory randomTextGeneratorFactory;

    public DatabaseServiceImpl(TicketsRepository ticketsRepository, CityRepository cityRepository, TicketTypeRepository ticketTypeRepository, RandomTextGeneratorFactory randomTextGeneratorFactory) {
        this.ticketsRepository = ticketsRepository;
        this.cityRepository = cityRepository;
        this.ticketTypeRepository = ticketTypeRepository;
        this.randomTextGeneratorFactory = randomTextGeneratorFactory;
    }

    @Override
    public ResponseEntity populateDatabase() {

        TicketType standardTicket = TicketType.valueOf("standard");
        TicketType halfPriceTicket = TicketType.valueOf("half-price");
        ticketTypeRepository.saveAndFlush(standardTicket);
        ticketTypeRepository.saveAndFlush(halfPriceTicket);

        City krakow = City.valueOf("Krakow");
        City warszawa = City.valueOf("Warszawa");
        City gdansk = City.valueOf("Gdansk");
        cityRepository.saveAndFlush(krakow);
        cityRepository.saveAndFlush(warszawa);
        cityRepository.saveAndFlush(gdansk);

        RandomTextGenerator nameGenerator = randomTextGeneratorFactory
                .getRandomTextGenerator(NAME_GENERATOR);

        RandomTextGenerator descriptionGenerator = randomTextGeneratorFactory
                .getRandomTextGenerator(DESCRIPTION_GENERATOR);

        RandomTextGenerator priceGenerator = randomTextGeneratorFactory.getRandomTextGenerator(PRICE_GENERATOR);


        Ticket ticket1 = Ticket.newBuilder()
                .setName(nameGenerator.provideText())
                .setDescription(descriptionGenerator.provideText())
                .setPrice(new BigDecimal(priceGenerator.provideText()))
                .setTicketType(standardTicket)
                .setCity(krakow)
                .build();


        ticketsRepository.saveAndFlush(ticket1);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
