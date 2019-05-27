package pl.xkoem.tickets.purchase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.TicketCodeEntity;
import pl.xkoem.tickets.payment.models.TicketPrivateKey;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Override
    public ResponseEntity<TicketPrivateKey> requestPurchase(String id) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Override
    public ResponseEntity<TicketCodeEntity> getBoughtTicket(TicketPrivateKey ticketPrivateKey) {
        return ResponseEntity.ok(null);
    }
}
