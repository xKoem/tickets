package pl.xkoem.tickets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ticket_types")
public class TicketTypeEntity {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public TicketTypeEntity() {
    }

    private TicketTypeEntity(String name) {
        this.name = name;
    }

    public static TicketTypeEntity valueOf(String ticketTypeName) {
        return new TicketTypeEntity(ticketTypeName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
