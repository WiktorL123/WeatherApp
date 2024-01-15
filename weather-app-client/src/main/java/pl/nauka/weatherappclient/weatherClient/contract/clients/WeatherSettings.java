package pl.nauka.weatherappclient.weatherClient.contract.clients;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
@Component
@Setter

public class WeatherSettings  implements IWeatherSettings{
    @Value("${accuweather.api.key}")
    private String apiKey;
    @Value("${accuweather.api.baseUrl}")
    private String baseUrl;
    @Value("${accuweather.api.version}")
    private int apiVersion;
    public WeatherSettings() {
        System.out.println("ApiKey: " + apiKey);
        System.out.println("BaseUrl: " + baseUrl);
        System.out.println("ApiVersion: " + apiVersion);

    }
    @Override
    public String getApiKey() {
        return apiKey;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public int getApiVersion() {
        return apiVersion;
    }




}
