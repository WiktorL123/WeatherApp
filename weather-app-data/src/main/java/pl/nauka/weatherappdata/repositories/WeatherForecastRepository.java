package pl.nauka.weatherappdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nauka.weatherappdata.model.WeatherForecast;

import java.util.Optional;

public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {
    Optional<WeatherForecast> findByCityId(Long cityId);
}
