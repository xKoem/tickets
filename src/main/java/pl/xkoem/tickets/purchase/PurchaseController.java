package pl.xkoem.tickets.purchase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.xkoem.tickets.models.TicketCode;
import pl.xkoem.tickets.payment.models.TicketPrivateKey;

@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping(value = "tickets/{id}/buy")
    public ResponseEntity<TicketPrivateKey> requestPurchase(@PathVariable("id") String id) {
        return purchaseService.requestPurchase(id);
    }

    @GetMapping(value = "tickets/buy")
    public ResponseEntity<TicketCode> getBoughtTicket(@RequestBody TicketPrivateKey ticketPrivateKey) {
        return purchaseService.getBoughtTicket(ticketPrivateKey);
    }
}
