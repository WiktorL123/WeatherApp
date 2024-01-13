package pl.nauka.weatherappdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nauka.weatherappdata.model.WeatherForecast;

public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {
}
