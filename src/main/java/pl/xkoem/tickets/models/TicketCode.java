package pl.xkoem.tickets.models;

import javax.persistence.*;

@Entity(name = "ticket_code")
public class TicketCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Ticket ticket;

    private String key;

    private TicketCode(Builder builder) {
        id = builder.id;
        ticket = builder.ticket;
        key = builder.key;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private Ticket ticket;
        private String key;

        private Builder() {
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTicket(Ticket ticket) {
            this.ticket = ticket;
            return this;
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public TicketCode build() {
            return new TicketCode(this);
        }
    }
}
