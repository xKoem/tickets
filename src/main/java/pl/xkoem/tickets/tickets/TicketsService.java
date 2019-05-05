package pl.xkoem.tickets.tickets;

import org.springframework.http.ResponseEntity;
import pl.xkoem.tickets.models.Ticket;
import pl.xkoem.tickets.models.TicketCode;

import java.util.List;

public interface TicketsService {

    ResponseEntity<List<Ticket>> getTickets();

    ResponseEntity<Ticket> createTicket(Ticket ticket);

    ResponseEntity<Ticket> getTicket(String id);

    ResponseEntity<TicketCode> addTicketCode(String id, TicketCode ticketCode);

    ResponseEntity<Ticket> updateTicket(String id, Ticket ticket);

    ResponseEntity<Ticket> deleteTicket(String id);

}
