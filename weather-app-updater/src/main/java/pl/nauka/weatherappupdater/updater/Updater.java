package pl.nauka.weatherappupdater.updater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nauka.weatherappclient.weatherClient.contract.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.DailyForecastDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherClient;
import pl.nauka.weatherappdata.repositories.ICatalogData;
import pl.nauka.weatherappupdater.mapers.*;

import java.util.List;


@Service
public class Updater implements IUpdate{

    private final ICatalogData dbCatalog;

    private final IWeatherClient client;

   private final CityMapper cityMapper;

   private final WeatherConditionsMapper conditionsMapper;

   private final ForecastMapper forecastMapper;


        @Autowired
    public Updater(ICatalogData  dbCatalog, IWeatherClient client, CityMapper cityMapper,
                   WeatherConditionsMapper conditionsMapper, ForecastMapper forecastMapper) {
        this.dbCatalog = dbCatalog;
        this.client = client;
        this.cityMapper = cityMapper;
        this.conditionsMapper = conditionsMapper;
        this.forecastMapper = forecastMapper;

    }

    @Override
    public void updateByCityName(String cityName ){
        //var cityDto=client.getCityInfo(cityName);
        var weather=client.getCurrentWeather("1-275174_1_AL");

      //  saveCity(cityDto);
       // saveConditions(cityDto);
       // saveForecast(cityDto);


    }

    @Override
    public CityDto getCity() {
        return client.getCityInfo("gdansk").get(0);
    }
    //    public CityDto getNameOfCity(String cityName){
//
//    }


    @Override
    public List<CityDto> getNameOfCity(String cityName) {
    return client.getCityInfo(cityName);

    }

    @Override
    public ForecastDto getForecastInfo() {
        return client.getWeatherForecast("1-275174_1_AL");
    }

    @Override
    public ConditionsDto getConditions() {
        return client.getCurrentWeather("1-275174_1_AL").get(0);
    }

    @Override
    public ConditionsDto getText(String cityKey) {
        return client.getCurrentWeather("1-275174_1_AL").get(0);
    }

//    private void saveForecast(CityDto cityDto) {
//        var forecastDto =client.getWeatherForecast(cityDto.getKey());
//        var forecast=forecastMapper.map(forecastDto);
//        dbCatalog.getWeatherForecast().save(forecast);
//    }

//    private void saveCity(CityDto cityDto) {
//        var city = cityMapper.map(cityDto);
//        dbCatalog.getCities().save(city);
//    }

//    private void saveConditions(CityDto cityDto) {
//        var conditionsDto=client.getCurrentWeather(cityDto.getKey());
//        var conditions=conditionsMapper.map(conditionsDto);
//        dbCatalog.getWeatherConditions().save(conditions);
//    }
}
