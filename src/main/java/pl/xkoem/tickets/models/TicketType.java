package pl.xkoem.tickets.models;

import javax.persistence.*;

@Entity(name = "ticket_types")
public class TicketType {

    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_type_id")
    private int id;

    private TicketType(String name) {
        this.name = name;
    }

    public static TicketType valueOf(String ticketTypeName) {
        return new TicketType(ticketTypeName);
    }

}
