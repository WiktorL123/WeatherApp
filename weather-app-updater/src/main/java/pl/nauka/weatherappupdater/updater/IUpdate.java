package pl.nauka.weatherappupdater.updater;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;
import pl.nauka.weatherappdata.model.City;

import java.util.List;
import java.util.Optional;

@Component
public interface IUpdate {
    void updateByCityName(String cityName);
    public void testAllMapers();

    boolean saveDataByCityName(String cityName);
    ConditionsDto getConditions();
    CityInfoDto getCity();
   ForecastDto getDailyForecast();
   City saveEntity();

    boolean deleteDataByCityId(Long id);

    boolean updateAll();
}
