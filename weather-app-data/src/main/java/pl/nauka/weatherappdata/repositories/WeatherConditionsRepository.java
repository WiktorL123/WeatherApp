package pl.nauka.weatherappdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nauka.weatherappdata.model.WeatherConditions;

import java.beans.JavaBean;

public interface WeatherConditionsRepository extends JpaRepository<WeatherConditions, Long> {
}
