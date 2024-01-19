package pl.nauka.weatherappdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nauka.weatherappdata.model.City;

public interface CityRespository extends JpaRepository<City, Long> {
    City findCitiesByCityName(String cityName);

}
