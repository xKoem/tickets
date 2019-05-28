package pl.xkoem.tickets.models;

import javax.persistence.*;

@Entity(name = "ticket_code")
public class TicketCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private TicketEntity ticketEntity;

    private String key;

    private TicketCodeEntity(Builder builder) {
        id = builder.id;
        ticketEntity = builder.ticketEntity;
        key = builder.key;
    }

    public TicketCodeEntity() {
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static final class Builder {
        private int id;
        private TicketEntity ticketEntity;
        private String key;

        private Builder() {
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setTicketEntity(TicketEntity ticketEntity) {
            this.ticketEntity = ticketEntity;
            return this;
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public TicketCodeEntity build() {
            return new TicketCodeEntity(this);
        }
    }
}
