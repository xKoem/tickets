package pl.xkoem.tickets.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity(name = "tickets")
public class TicketEntity {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @OneToOne
    private TicketTypeEntity ticketTypeEntity;
    @OneToOne
    private CityEntity cityEntity;
    private BigDecimal price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public TicketEntity() {
    }

    private TicketEntity(Builder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
        ticketTypeEntity = builder.ticketTypeEntity;
        cityEntity = builder.cityEntity;
        price = builder.price;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketTypeEntity getTicketTypeEntity() {
        return ticketTypeEntity;
    }

    public void setTicketTypeEntity(TicketTypeEntity ticketTypeEntity) {
        this.ticketTypeEntity = ticketTypeEntity;
    }

    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static final class Builder {
        private int id;
        private @NotNull String name;
        private @NotNull String description;
        private TicketTypeEntity ticketTypeEntity;
        private CityEntity cityEntity;
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

        public Builder setTicketTypeEntity(TicketTypeEntity ticketTypeEntity) {
            this.ticketTypeEntity = ticketTypeEntity;
            return this;
        }

        public Builder setCityEntity(CityEntity cityEntity) {
            this.cityEntity = cityEntity;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public TicketEntity build() {
            return new TicketEntity(this);
        }
    }
}
