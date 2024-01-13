package pl.nauka.weatherappdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cityKey;
    private String cityName;
    private String Country;
    private String timeZone;

    public City(long id, String cityKey, String cityName, String country, String timeZone) {
        this.id = id;
        this.cityKey = cityKey;
        this.cityName = cityName;
        Country = country;
        this.timeZone = timeZone;
    }

    public City() {
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
