package pl.nauka.weatherappwebapi.services;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.repositories.ICatalogData;
import pl.nauka.weatherappdata.repositories.WeatherConditionsRepository;
import pl.nauka.weatherappdata.repositories.WeatherForecastRepository;
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
              .map(this::maptoDto)
              .collect(Collectors.toList());
     for (var city:list)
         System.out.println(city.getCityKey());
     return  list;

    }
    private CityDto maptoDto(City city){
        return  new CityDto(
                city.getCityKey(),
                city.getCityName(),
                city.getCountry(),
                city.getTimeZone()
        );
    }

    public List<ConditionsDto> getConditions() {
        return null;
    }
}
