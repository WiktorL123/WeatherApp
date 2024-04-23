package pl.nauka.weatherappupdater.updater;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;

import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherClient;
import pl.nauka.weatherappdata.model.City;

import pl.nauka.weatherappdata.model.WeatherConditions;
import pl.nauka.weatherappdata.model.WeatherForecast;
import pl.nauka.weatherappdata.repositories.ICatalogData;
import pl.nauka.weatherappupdater.mapers.*;

import java.util.ArrayList;


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

//        var forecastDto=client.getWeatherForecast(cityDto.getKey(), cityName);
//
//        var conditionsDto=client.getCurrentWeather(cityDto.getKey(), cityName).get(0);
//        WeatherForecast forecast=forecastMapper.map(forecastDto, cityDto);


       // WeatherConditions conditions = conditionsMapper.map(conditionsDto, cityDto);
//        System.out.println(forecast.getDescription());
//        System.out.println(conditions.getDescription());
//        System.out.println(city.getCityName());
//        System.out.println("------------------------------");
//        System.out.println(forecast.getCity().getCityKey());
//        System.out.println(conditions.getCity().getCityKey());

    }

    @Override
    @Transactional
    public boolean saveDataByCityName(String cityName) {
        var cityDto = getCityInfoDto(cityName);
        var existingCity = dbCatalog.getCities().findCitiesByCityName(cityDto.getEnglishName());
        if (existingCity != null) {
            return false;

        } else {
            var city = cityMapper.map(cityDto);
            dbCatalog.getCities().save(city);
            saveForecast(cityDto, city);
            saveConditions(cityDto, city);
            return true;
        }
    }

    private void saveConditions(CityInfoDto cityDto, City city) {
        var conditionsDto = client.getCurrentWeather(cityDto.getKey(), cityDto.getEnglishName()).get(0);
        var conditions = conditionsMapper.map(conditionsDto, city);
        dbCatalog.getWeatherConditions().save(conditions);
    }

    private void saveForecast(CityInfoDto cityDto, City city) {
        var forecastDto = client.getWeatherForecast(cityDto.getKey(), cityDto.getEnglishName());
        var forecast = forecastMapper.map(forecastDto, city);
        dbCatalog.getWeatherForecast().save(forecast);
    }

    private CityInfoDto getCityInfoDto(String cityName) {
        var cityDto = client.getCityInfo(cityName).get(0);
        return cityDto;
    }






    @Override
    public void updateByCityName(String cityName) {
        var existingCity = dbCatalog.getCities().findCitiesByCityName(cityName);

        if (existingCity != null) {
            var cityInfo = getCityInfoDto(cityName);
            var city = cityMapper.map(cityInfo);

            var existingConditions = dbCatalog.getWeatherConditions().findByCityId(existingCity.getId()).orElse(null);
            var existingForecast = dbCatalog.getWeatherForecast().findByCityId(existingCity.getId()).orElse(null);

            if (existingForecast != null && existingConditions != null) {
                var conditionsDto = client.getCurrentWeather(cityInfo.getKey(), cityInfo.getEnglishName()).get(0);
                var conditions = conditionsMapper.map(conditionsDto, city);

                var forecastDto = client.getWeatherForecast(cityInfo.getKey(), cityInfo.getEnglishName());
                var forecast = forecastMapper.map(forecastDto, city);

                prepareForecast(existingForecast, forecast);
                prepareCondidions(existingConditions, existingCity, conditions);

                dbCatalog.getWeatherForecast().save(existingForecast);
                dbCatalog.getWeatherConditions().save(existingConditions);
            }
        }
    }

    private static void prepareCondidions(WeatherConditions existingConditions, City existingCity, WeatherConditions conditions) {
        existingConditions.setCity(existingCity);
        existingConditions.setTemperature(conditions.getTemperature());
        existingConditions.setDescription(conditions.getDescription());
        existingConditions.setDate(conditions.getDate());
    }

    private static void prepareForecast(WeatherForecast existingForecast, WeatherForecast forecast) {
        existingForecast.setDescription(forecast.getDescription());
        existingForecast.setMinTemperature(forecast.getMinTemperature());
        existingForecast.setMaxTemperature(forecast.getMaxTemperature());
        existingForecast.setDateTime(forecast.getDateTime());
    }


        @Override
    public boolean deleteDataByCityId(Long id) {
        try {
            var cityOptional = dbCatalog.getCities().findById(id);
            var city = cityOptional.orElse(null);

            if (city == null) {

                return false;
            } else {
                var conditions = dbCatalog.getWeatherConditions().findByCityId(id).orElse(null);
                var forecasts = dbCatalog.getWeatherForecast().findByCityId(id).orElse(null);


                dbCatalog.getWeatherConditions().delete(conditions);
                dbCatalog.getWeatherForecast().delete(forecasts);


                dbCatalog.getCities().delete(city);

                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


        @Override
        public boolean updateAll() {
            var allCities = new ArrayList<>(dbCatalog.getCities().findAll());
            for (var city : allCities) {
                updateByCityName(city.getCityName());
            }
            return true;
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
