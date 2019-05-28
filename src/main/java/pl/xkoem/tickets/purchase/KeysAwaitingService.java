package pl.xkoem.tickets.purchase;

import org.springframework.stereotype.Service;
import pl.xkoem.tickets.payment.models.TicketPrivateKey;

import java.util.HashMap;

@Service
public class KeysAwaitingService {
    private HashMap<TicketPrivateKey, Boolean> keysAwaiting = new HashMap<>();

    boolean containsKey(TicketPrivateKey ticketPrivateKey) {
        return keysAwaiting.containsKey(ticketPrivateKey);
    }

    void put(TicketPrivateKey ticketPrivateKey, Boolean isPaid) {
        keysAwaiting.put(ticketPrivateKey, isPaid);
    }

    boolean isTicketPaid(TicketPrivateKey ticketPrivateKey) {
        return keysAwaiting.getOrDefault(ticketPrivateKey, false);
    }

    String getTicketId(TicketPrivateKey ticketPrivateKey) {
        return ticketPrivateKey.getTicketId();
    }

    public boolean setKeyAsPaid(TicketPrivateKey ticketPrivateKey) {
        if (!keysAwaiting.containsKey(ticketPrivateKey)) {
            return false;
        }
        keysAwaiting.put(ticketPrivateKey, true);
        return true;
    }
}
