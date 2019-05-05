package pl.xkoem.tickets.tickets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.Ticket;
import pl.xkoem.tickets.models.TicketCode;

import java.util.Collections;
import java.util.List;

@Service
public class TicketsServiceImpl implements TicketsService {

    @Override
    public ResponseEntity<List<Ticket>> getTickets() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @Override
    public ResponseEntity<Ticket> createTicket(Ticket ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @Override
    public ResponseEntity<Ticket> getTicket(String id) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<TicketCode> addTicketCode(String id, TicketCode ticketCode) {
        return null;
    }

    @Override
    public ResponseEntity<Ticket> updateTicket(String id, Ticket ticket) {
        return null;
    }

    @Override
    public ResponseEntity<Ticket> deleteTicket(String id) {
        return null;
    }
}
