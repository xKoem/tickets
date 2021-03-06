package pl.xkoem.tickets.payment;

import org.springframework.http.ResponseEntity;
import pl.xkoem.tickets.payment.models.TicketPrivateKey;

public interface PaymentService {
    ResponseEntity<TicketPrivateKey> payForTicket(TicketPrivateKey ticketPrivateKey);
}
