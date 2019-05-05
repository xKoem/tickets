package pl.xkoem.tickets.tickets;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.xkoem.tickets.models.Ticket;
import pl.xkoem.tickets.models.TicketCode;

import java.util.List;

@RestController
public class TicketsController {

    private final TicketsService ticketsService;

    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    //todo: add ticket filter
    @GetMapping(value = "tickets")
    public ResponseEntity<List<Ticket>> getTickets() {
        return ticketsService.getTickets();
    }

    @PostMapping(value = "tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ticketsService.createTicket(ticket);
    }

    @GetMapping(value = "tickets/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("id") String id) {
        return ticketsService.getTicket(id);
    }

    @PostMapping(value = "tickets/{id}")
    public ResponseEntity<TicketCode> addTicketCode(@PathVariable("id") String id, @RequestBody TicketCode ticketCode) {
        return ticketsService.addTicketCode(id, ticketCode);
    }

    @PutMapping(value = "tickets/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("id") String id, @RequestBody Ticket ticket) {
        return ticketsService.updateTicket(id, ticket);
    }


    @DeleteMapping(value = "tickets/{id}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable("id") String id) {
        return ticketsService.deleteTicket(id);
    }
}
