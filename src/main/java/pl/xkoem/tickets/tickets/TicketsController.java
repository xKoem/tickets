package pl.xkoem.tickets.tickets;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.xkoem.tickets.models.TicketCodeEntity;
import pl.xkoem.tickets.models.TicketEntity;

import java.util.List;

@RestController
public class TicketsController {

    private final TicketsService ticketsService;

    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    //todo: add ticket filter
    @GetMapping(value = "tickets")
    public ResponseEntity<List<TicketEntity>> getTickets() {
        return ticketsService.getTickets();
    }

    @PostMapping(value = "tickets")
    public ResponseEntity<TicketEntity> createTicket(@RequestBody TicketEntity ticketEntity) {
        return ticketsService.createTicket(ticketEntity);
    }

    @GetMapping(value = "tickets/{id}")
    public ResponseEntity<TicketEntity> getTicket(@PathVariable("id") String id) {
        return ticketsService.getTicket(id);
    }

    @PostMapping(value = "tickets/code")
    public ResponseEntity<TicketCodeEntity> addTicketCode(@RequestBody TicketCodeEntity ticketCodeEntity) {
        return ticketsService.addTicketCode(ticketCodeEntity);
    }

    @PutMapping(value = "tickets/{id}")
    public ResponseEntity<TicketEntity> updateTicket(@PathVariable("id") String id, @RequestBody TicketEntity ticketEntity) {
        return ticketsService.updateTicket(id, ticketEntity);
    }


    @DeleteMapping(value = "tickets/{id}")
    public ResponseEntity<TicketEntity> deleteTicket(@PathVariable("id") String id) {
        return ticketsService.deleteTicket(id);
    }
}
