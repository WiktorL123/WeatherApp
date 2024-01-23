package pl.nauka.weatherappwebapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherConditions;
import pl.nauka.weatherappdata.model.WeatherForecast;
import pl.nauka.weatherappdata.repositories.ICatalogData;
import pl.nauka.weatherappdata.repositories.WeatherForecastRepository;
import pl.nauka.weatherappwebapi.contract.CityDto;
import pl.nauka.weatherappwebapi.contract.ConditionsDto;
import pl.nauka.weatherappwebapi.contract.ForecastDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private  final ICatalogData db;


    public List<CityDto> getCities() {
      var cities=db.getCities().findAll();
     var list= cities.stream()
              .map(this::MaptoCityDto)
              .collect(Collectors.toList());
     for (var city:list)
         System.out.println(city.getCityKey());
     return  list;

    }
    private CityDto MaptoCityDto(City city){
        return  new CityDto(
                city.getId(),
                city.getCityKey(),
                city.getCityName(),
                city.getCountry(),
                city.getTimeZone()
        );
    }

    public List<ConditionsDto> getConditions() {
        var weatherConditions = db.getWeatherConditions().findAllWithCity();
      return  weatherConditions.stream()
                .map(this::mapToConditionsDto).collect(Collectors.toList());
    }
    private ConditionsDto mapToConditionsDto(WeatherConditions conditions){
        return new ConditionsDto(conditions.getCity().getCityName()
        , conditions.getTemperature(), conditions.getDescription(), conditions.getDate());
    }

    public List<ForecastDto> getForecasts() {
        var forecasts = db.getWeatherForecast().findAllWithCity();
        return forecasts.stream().map(
                this::mapToForecastsDto).collect(Collectors.toList());

    }

    private ForecastDto mapToForecastsDto(WeatherForecast weatherForecast) {
        return new ForecastDto(weatherForecast.getCity().getCityName(),
                weatherForecast.getDateTime(),
                weatherForecast.getMaxTemperature(),
                weatherForecast.getMinTemperature(),
                weatherForecast.getDescription());
    }

    public boolean deleteWeatherData(Long id) {
        var city = findCityById(id);
        if (city==null)
            return false;
        else {
            var conditions = findConditionsByCityId(id);
            var forecasts = findForecastsByCityId(id);
            db.getWeatherConditions().delete(conditions);
            db.getWeatherForecast().delete(forecasts);
            db.getCities().delete(city);
            return true;
        }
    }

    private WeatherForecast findForecastsByCityId(Long id) {
        return
                db.getWeatherForecast()
                        .findByCityId(id).orElse(null);
    }

    private WeatherConditions findConditionsByCityId(Long id) {
      return
              db.getWeatherConditions().
                      findByCityId(id).orElse(null);
    }

    public City findCityById(Long id) {
        return db.getCities()
                .findById(id).orElse(null);
    }

    public CityDto findCityDtoById(Long id) {
        return
                MaptoCityDto(db.getCities().findById(id)
                        .orElse(null));
    }
}
