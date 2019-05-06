package pl.xkoem.tickets.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "tickets")
public class Ticket {

    @NotNull
    private final String name;
    @NotNull
    private final String description;
    @OneToOne
    private final TicketType ticketType;
    @OneToOne
    private final City city;
    private final BigDecimal price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;

    private Ticket(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        ticketType = builder.ticketType;
        city = builder.city;
        price = builder.price;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private int id;
        private @NotNull String name;
        private @NotNull String description;
        private TicketType ticketType;
        private City city;
        private BigDecimal price;

        private Builder() {
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(@NotNull String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(@NotNull String description) {
            this.description = description;
            return this;
        }

        public Builder setTicketType(TicketType ticketType) {
            this.ticketType = ticketType;
            return this;
        }

        public Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
