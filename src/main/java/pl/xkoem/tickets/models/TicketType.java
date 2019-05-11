package pl.xkoem.tickets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ticket_types")
public class TicketType {

    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private TicketType(String name) {
        this.name = name;
    }

    public static TicketType valueOf(String ticketTypeName) {
        return new TicketType(ticketTypeName);
    }

}
