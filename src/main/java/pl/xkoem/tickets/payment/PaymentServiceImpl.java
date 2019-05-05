package pl.xkoem.tickets.payment;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.TicketPrivateKey;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public ResponseEntity<TicketPrivateKey> payForTicket(TicketPrivateKey ticketPrivateKey) {
        return null;
    }
}
