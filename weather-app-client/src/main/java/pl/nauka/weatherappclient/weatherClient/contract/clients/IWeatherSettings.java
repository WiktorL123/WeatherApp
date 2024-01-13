package pl.nauka.weatherappclient.weatherClient.contract.clients;

import org.springframework.web.util.UriComponentsBuilder;

public interface IWeatherSettings {
    String getApiKey();
    String getBaseUrl();
    int getApiVersion();
    UriComponentsBuilder getComponentsBuilder();

}
