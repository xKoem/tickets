package pl.xkoem.tickets.purchase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.TicketCodeEntity;
import pl.xkoem.tickets.payment.models.TicketPrivateKey;
import pl.xkoem.tickets.tickets.repository.TicketCodeRepository;
import pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGenerator;
import pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGeneratorFactory;
import pl.xkoem.tickets.utils.randomtextgeneration.RandomTextGeneratorType;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private static final int MAX_NUMBER_OF_RETRIES = 20;

    private final KeysAwaitingService keysAwaitingService;
    private final TicketCodeRepository ticketCodeRepository;
    private final RandomTextGenerator keyGenerator;

    public PurchaseServiceImpl(KeysAwaitingService keysAwaitingService, TicketCodeRepository ticketCodeRepository) {
        this.keysAwaitingService = keysAwaitingService;
        this.ticketCodeRepository = ticketCodeRepository;
        this.keyGenerator = new RandomTextGeneratorFactory()
                .getRandomTextGenerator(RandomTextGeneratorType.KEY_GENERATOR);
    }

    @Override
    public ResponseEntity<TicketPrivateKey> requestPurchase(String id) {
        Optional<TicketPrivateKey> ticketPrivateKey = Stream.generate(() -> TicketPrivateKey.newBuilder()
                .setKey(keyGenerator.provideText())
                .setTicketId(id)
                .build()
        )
                .limit(MAX_NUMBER_OF_RETRIES)
                .filter(not(keysAwaitingService::containsKey))
                .findFirst();

        keysAwaitingService.put(ticketPrivateKey.orElseThrow(KeyCouldNotBeGeneratedException::new), false);
        return ResponseEntity.status(HttpStatus.OK).body(ticketPrivateKey.get());
    }

    @Override
    public ResponseEntity<TicketCodeEntity> getBoughtTicket(TicketPrivateKey ticketPrivateKey) {
        if (keysAwaitingService.isTicketPaid(ticketPrivateKey)) {
            TicketCodeEntity ticket = ticketCodeRepository
                    .findFirstByTicketEntityId(Integer.valueOf(keysAwaitingService.getTicketId(ticketPrivateKey)));
            ticketCodeRepository.delete(ticket);
            ticketCodeRepository.flush();
            return ResponseEntity.ok(ticket);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
