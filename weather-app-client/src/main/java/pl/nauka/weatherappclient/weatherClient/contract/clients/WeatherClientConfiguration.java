package pl.nauka.weatherappclient.weatherClient.contract.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherClientConfiguration {

    public IWeatherSettings getSettings(     @Value("${accuweather.api.key}")
                                             String apiKey,
                                             @Value("${accuweather.api.baseUrl}")
                                             String baseUrl,
                                             @Value("${accuweather.api.version}")
                                             int version ){

        return new WeatherSettings();
    }




}
