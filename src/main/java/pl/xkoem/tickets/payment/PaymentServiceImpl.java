package pl.xkoem.tickets.payment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.payment.models.TicketPrivateKey;
import pl.xkoem.tickets.purchase.KeysAwaitingService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final KeysAwaitingService keysAwaitingService;

    public PaymentServiceImpl(KeysAwaitingService keysAwaitingService) {
        this.keysAwaitingService = keysAwaitingService;
    }

    @Override
    public ResponseEntity<TicketPrivateKey> payForTicket(TicketPrivateKey ticketPrivateKey) {
        return ResponseEntity.status(keysAwaitingService.setKeyAsPaid(ticketPrivateKey) ?
                HttpStatus.OK :
                HttpStatus.CONFLICT)
                .body(ticketPrivateKey);

    }
}
