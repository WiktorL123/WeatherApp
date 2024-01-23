package pl.nauka.weatherappdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.nauka.weatherappdata.model.WeatherConditions;


import java.util.List;
import java.util.Optional;

public interface WeatherConditionsRepository extends JpaRepository<WeatherConditions, Long> {
    Optional<WeatherConditions> findByCityId(Long cityId);
@Query("SELECT wc from WeatherConditions wc JOIN wc.city c")
    List<WeatherConditions> findAllWithCity();
}
