package pl.nauka.weatherappupdater.updater;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherClient;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherSettings;
import pl.nauka.weatherappdata.repositories.ICatalogData;
import pl.nauka.weatherappupdater.mapers.*;


@Service
public class Updater implements IUpdate{

    private final ICatalogData dbCatalog;

    private final IWeatherClient client;

   private final CityMapper cityMapper;

   private final WeatherConditionsMapper conditionsMapper;

   private final ForecastMapper forecastMapper;

   private final IWeatherSettings settings;
        @Autowired
    public Updater(ICatalogData dbCatalog, IWeatherClient client, CityMapper cityMapper,
                   WeatherConditionsMapper conditionsMapper, ForecastMapper forecastMapper,
                   IWeatherSettings settings) {
        this.dbCatalog = dbCatalog;
        this.client = client;
        this.cityMapper = cityMapper;
        this.conditionsMapper = conditionsMapper;
        this.forecastMapper = forecastMapper;
        this.settings = settings;
    }

    @Override
    public void updateByCityName(String cityName ){
        var cityDto=client.getCityInfo(cityName);
        saveCity(cityDto);
        saveConditions(cityDto);
        saveForecast(cityDto);


    }

    private void saveForecast(CityDto cityDto) {
        var forecastDto =client.getWeatherForecast(cityDto.getKey());
        var forecast=forecastMapper.map(forecastDto);
        dbCatalog.getWeatherForecast().save(forecast);
    }

    private void saveCity(CityDto cityDto) {
        var city = cityMapper.map(cityDto);
        dbCatalog.getCities().save(city);
    }

    private void saveConditions(CityDto cityDto) {
        var conditionsDto=client.getCurrentWeather(cityDto.getKey());
        var conditions=conditionsMapper.map(conditionsDto);
        dbCatalog.getWeatherConditions().save(conditions);
    }
}
