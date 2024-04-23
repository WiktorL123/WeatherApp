package pl.nauka.weatherappdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherConditions;


import java.util.List;
import java.util.Optional;

public interface WeatherConditionsRepository extends JpaRepository<WeatherConditions, Long> {
    Optional<WeatherConditions> findByCityId(Long cityId);
@Query("SELECT wc from WeatherConditions wc JOIN wc.city c")
    List<WeatherConditions> findAllWithCity();


//@Query("SELECT City .city_name, WeatherConditions .description from City join WeatherConditions  on  + City .id=WeatherConditions .city_id WHERE City .cityName=:cityName");
//    WeatherConditions findByCityName(@Param("cityName") String cityName);
    WeatherConditions findWeatherConditionsByCity(City city);
}
