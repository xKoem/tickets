package pl.xkoem.tickets.payment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.xkoem.tickets.payment.models.TicketPrivateKey;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "pay")
    public ResponseEntity<TicketPrivateKey> payForTicket(@RequestBody TicketPrivateKey ticketPrivateKey) {
        return paymentService.payForTicket(ticketPrivateKey);
    }
}
