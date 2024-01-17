package pl.nauka.weatherappupdater.updater;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.DailyForecastDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;

import java.util.List;

@Component
public interface IUpdate {
    void updateByCityName(String cityName);
   List<CityDto> getNameOfCity(String cityName);
    ConditionsDto getText(String cityKey);
    ConditionsDto getConditions();
    CityDto getCity();

    ForecastDto getForecastInfo();
}
