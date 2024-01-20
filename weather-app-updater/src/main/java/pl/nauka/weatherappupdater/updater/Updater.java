package pl.nauka.weatherappupdater.updater;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.DailyForecastDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherClient;
import pl.nauka.weatherappdata.model.City;
import pl.nauka.weatherappdata.model.WeatherConditions;
import pl.nauka.weatherappdata.model.WeatherForecast;
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
    public void testAllMapers(){
            String cityName="bartoszyce";
            var cityDto=client.getCityInfo(cityName).get(0);
        var city=cityMapper.map(cityDto);

        var forecastDto=client.getWeatherForecast(cityDto.getKey(), cityName);

        var conditionsDto=client.getCurrentWeather(cityDto.getKey(), cityName).get(0);
        WeatherForecast forecast=forecastMapper.map(forecastDto, cityDto);


        WeatherConditions conditions = conditionsMapper.map(conditionsDto, cityDto);
        System.out.println(forecast.getDescription());
        System.out.println(conditions.getDescription());
        System.out.println(city.getCityName());
        System.out.println("------------------------------");
        System.out.println(forecast.getCity().getCityKey());
        System.out.println(conditions.getCity().getCityKey());

    }

    @Override
    @Transactional
    public void saveDataByCityName(String cityName) {
        var cityDto = client.getCityInfo(cityName).get(0);
        var city = cityMapper.map(cityDto);
        var existingCity = dbCatalog.getCities().findCitiesByCityName(cityDto.getEnglishName());

        if (existingCity != null) {
            throw new RuntimeException("City exists in database");
        } else {
            dbCatalog.getCities().save(city);
            var forecastDto = client.getWeatherForecast(cityDto.getKey(), cityDto.getEnglishName());
            var conditionsDto = client.getCurrentWeather(cityDto.getKey(), cityDto.getEnglishName()).get(0);
            var forecast = forecastMapper.map(forecastDto, cityDto);
            var conditions = conditionsMapper.map(conditionsDto, cityDto);
            dbCatalog.getWeatherForecast().save(forecast);
            dbCatalog.getWeatherConditions().save(conditions);
        }
    }
    private void saveForecast(CityInfoDto cityDto, City city) {
       var forecastDto=client.getWeatherForecast(cityDto.getKey(), cityDto.getEnglishName());
        var forecast=forecastMapper.map(forecastDto, cityDto);
        forecast.setCity(city);
         dbCatalog.getWeatherForecast().save(forecast);
    }

    private void saveCity(CityInfoDto cityDto) {

    }

    private void saveConditions(CityInfoDto cityDto) {

        var conditionsDto=client.getCurrentWeather(cityDto.getKey(), cityDto.getEnglishName()).get(0);
        var conditions=conditionsMapper.map(conditionsDto, cityDto);
        dbCatalog.getWeatherConditions().save(conditions);
    }

    @Override
    public void updateByCityName(String cityName){

        var existingEntity=dbCatalog.getCities().findCitiesByCityName(cityName);




    }
    @Override
    public ForecastDto getDailyForecast(){
            String string="1-275174_1_AL";

            return client.getWeatherForecast(string, "gdansk");

    }

    @Override
    public City saveEntity() {
        return null;
    }

    @Override
    public ConditionsDto getConditions() {
        String string="1-275174_1_AL";
        return client.getCurrentWeather(string, "gdansk").get(0);
    }

    @Override
    public CityInfoDto getCity() {
        return null;
    }
    //    @Override
//    public CityInfoDto getCity() {
//        return client.getCityInfo("bartoszyce").get(0);
//    }
//        public CityDto getNameOfCity(String cityName){
//
//    }


//    @Override
//    public List<CityInfoDto> getNameOfCity(String cityName) {
//    return client.getCityInfo(cityName);
//
//    }

//    @Override
//    public ForecastDto getForecastInfo() {
//        return client.getWeatherForecast("266362");
//    }

//    @Override
//    public ConditionsDto getConditions() {
//        return client.getCurrentWeather("266362").get(0);
//    }

//    @Override
//    public ConditionsDto getText(String cityKey) {
//        return client.getCurrentWeather("1-275174_1_AL").get(0);
//    }


}
