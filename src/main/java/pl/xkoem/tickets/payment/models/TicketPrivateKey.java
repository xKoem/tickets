package pl.xkoem.tickets.payment.models;

import java.util.Objects;

public class TicketPrivateKey {

    private String key;
    private String ticketId;

    public TicketPrivateKey() {
    }

    private TicketPrivateKey(Builder builder) {
        key = builder.key;
        ticketId = builder.ticketId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketPrivateKey that = (TicketPrivateKey) o;
        return Objects.equals(key, that.key) &&
                Objects.equals(ticketId, that.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, ticketId);
    }

    public static final class Builder {
        private String key;
        private String ticketId;

        private Builder() {
        }

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public Builder setTicketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public TicketPrivateKey build() {
            return new TicketPrivateKey(this);
        }
    }

}
