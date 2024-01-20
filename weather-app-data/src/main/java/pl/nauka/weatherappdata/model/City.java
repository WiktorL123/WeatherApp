package pl.nauka.weatherappdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
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
    private String country;
    private String timeZone;



    public City() {
    }

    public City(String cityKey, String cityName, String country, String timeZone) {
        this.cityKey = cityKey;
        this.cityName = cityName;
        this.country = country;
        this.timeZone = timeZone;
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
