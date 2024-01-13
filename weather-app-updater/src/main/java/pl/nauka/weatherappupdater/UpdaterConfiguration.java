package pl.nauka.weatherappupdater;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherClient;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherSettings;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherClient;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherSettings;
import pl.nauka.weatherappdata.repositories.*;
import pl.nauka.weatherappupdater.mapers.CityMapper;
import pl.nauka.weatherappupdater.mapers.ForecastMapper;
import pl.nauka.weatherappupdater.mapers.WeatherConditionsMapper;
import pl.nauka.weatherappupdater.updater.IUpdate;
import pl.nauka.weatherappupdater.updater.Updater;

@Configuration
public class UpdaterConfiguration {
    private IWeatherSettings settings;
    private WeatherSettings weatherSettings;
  private   RestTemplate restTemplate;
    private ICatalogData data;
   private IWeatherClient client;
    private WeatherConditionsRepository weatherConditionsRepository;
   private CityRespository cityRespository;
   private WeatherForecastRepository weatherForecastRepository;
  private   CityMapper cityMapper;
  private WeatherConditionsMapper weatherConditionsMapper;
  private ForecastMapper forecastMapper;

  //  @Bean
//    public IUpdate getUpdater(){
//        return new Updater(data, client, cityMapper, weatherConditionsMapper, forecastMapper, settings);
//    }
    @Bean
    public IWeatherSettings getSettings(){
        return new WeatherSettings();
    }
    @Bean
    public IWeatherClient getClient(){
        return new WeatherClient(settings, restTemplate);
    }
    @Bean
    public ICatalogData getData(){
        return new WeatherAppDataCatalog(weatherForecastRepository, weatherConditionsRepository, cityRespository);

    }
}
