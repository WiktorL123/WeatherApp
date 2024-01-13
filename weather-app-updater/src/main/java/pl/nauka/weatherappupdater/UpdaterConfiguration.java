package pl.nauka.weatherappupdater;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherClient;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherSettings;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherClient;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherSettings;
import pl.nauka.weatherappdata.repositories.*;

@Configuration
public class UpdaterConfiguration {
    IWeatherSettings settings;
    WeatherSettings weatherSettings;
    RestTemplate restTemplate;
    ICatalogData data;
    IWeatherClient client;
    WeatherConditionsRepository weatherConditionsRepository;
    CityRespository cityRespository;
    WeatherForecastRepository weatherForecastRepository;
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
