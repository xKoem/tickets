package pl.xkoem.tickets.purchase;

import org.springframework.http.ResponseEntity;
import pl.xkoem.tickets.models.TicketCode;
import pl.xkoem.tickets.models.TicketPrivateKey;

public interface PurchaseService {

    ResponseEntity<TicketPrivateKey> requestPurchase(String id);

    ResponseEntity<TicketCode> getBoughtTicket(TicketPrivateKey ticketPrivateKey);


}
