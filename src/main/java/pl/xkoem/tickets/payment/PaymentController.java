package pl.xkoem.tickets.payment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.xkoem.tickets.models.TicketPrivateKey;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "pay")
    public ResponseEntity<TicketPrivateKey> payForTicket(@RequestBody TicketPrivateKey ticketPrivateKey) {
        return paymentService.payForTicket(ticketPrivateKey);
    }
}
