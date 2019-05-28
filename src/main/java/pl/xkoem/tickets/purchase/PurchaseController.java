package pl.xkoem.tickets.purchase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.xkoem.tickets.models.TicketCodeEntity;
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

    @PostMapping(value = "tickets/buy")
    public ResponseEntity<TicketCodeEntity> getBoughtTicket(@RequestBody TicketPrivateKey ticketPrivateKey) {
        return purchaseService.getBoughtTicket(ticketPrivateKey);
    }
}
