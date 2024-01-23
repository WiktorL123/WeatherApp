package pl.nauka.weatherappdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.nauka.weatherappdata.model.WeatherForecast;

import java.util.List;
import java.util.Optional;

public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {
    Optional<WeatherForecast> findByCityId(Long cityId);
@Query("SELECT fc from WeatherForecast  fc JOIN  fc.city city")
    List<WeatherForecast> findAllWithCity();
}
