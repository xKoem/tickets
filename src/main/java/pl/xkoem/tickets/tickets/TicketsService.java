package pl.xkoem.tickets.tickets;

import org.springframework.http.ResponseEntity;
import pl.xkoem.tickets.models.TicketCodeEntity;
import pl.xkoem.tickets.models.TicketEntity;

import java.util.List;

public interface TicketsService {

    ResponseEntity<List<TicketEntity>> getTickets();

    ResponseEntity<TicketEntity> createTicket(TicketEntity ticketEntity);

    ResponseEntity<TicketEntity> getTicket(String id);

    ResponseEntity<TicketCodeEntity> addTicketCode(TicketCodeEntity ticketCodeEntity);

    ResponseEntity<TicketEntity> updateTicket(String id, TicketEntity ticketEntity);

    ResponseEntity<TicketEntity> deleteTicket(String id);
}
