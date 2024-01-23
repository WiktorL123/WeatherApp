package pl.nauka.weatherappwebapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherConditions;
import pl.nauka.weatherappdata.repositories.ICatalogData;
import pl.nauka.weatherappwebapi.contract.CityDto;
import pl.nauka.weatherappwebapi.contract.ConditionsDto;

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
                city.getCityKey(),
                city.getCityName(),
                city.getCountry(),
                city.getTimeZone()
        );
    }

    public List<ConditionsDto> getConditions() {
        var weatherConditions = db.getWeatherConditions().findAllWithCity();
      return  weatherConditions.stream()
                .map(conditions->mapToConditionsDto(conditions)).collect(Collectors.toList());
    }
    private ConditionsDto mapToConditionsDto(WeatherConditions conditions){
        return new ConditionsDto(conditions.getCity().getCityName()
        , conditions.getTemperature(), conditions.getDescription(), conditions.getDate());
    }
}
