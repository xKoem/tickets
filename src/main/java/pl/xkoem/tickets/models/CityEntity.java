package pl.xkoem.tickets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "city")
public class CityEntity {

    @NotNull
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public CityEntity() {
    }

    private CityEntity(String name) {
        this.name = name;
    }

    public static CityEntity valueOf(String cityName) {
        return new CityEntity(cityName);
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
