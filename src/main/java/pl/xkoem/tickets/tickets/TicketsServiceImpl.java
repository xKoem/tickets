package pl.xkoem.tickets.tickets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.xkoem.tickets.models.Ticket;
import pl.xkoem.tickets.models.TicketCode;
import pl.xkoem.tickets.tickets.repository.TicketsRepository;

import java.util.List;

@Service
public class TicketsServiceImpl implements TicketsService {

    private final TicketsRepository ticketsRepository;

    public TicketsServiceImpl(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public ResponseEntity<List<Ticket>> getTickets() {
        return ResponseEntity.ok(ticketsRepository.findAll());
    }

    @Override
    public ResponseEntity<Ticket> createTicket(Ticket ticket) {
        var savedTicket = ticketsRepository.saveAndFlush(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
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
