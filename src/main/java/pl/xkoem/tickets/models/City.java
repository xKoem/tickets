package pl.xkoem.tickets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "city")
public class City {

    @NotNull
    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private City(String name) {
        this.name = name;
    }

    public static City valueOf(String cityName) {
        return new City(cityName);
    }
}
