package pl.nauka.weatherappupdater.updater;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;

import java.util.List;

@Component
public interface IUpdate {
    void updateByCityName(String cityName);


    ConditionsDto getConditions();
    CityInfoDto getCity();

   ForecastDto getDailyForecast();
}
