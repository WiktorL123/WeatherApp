package pl.nauka.weatherappclient.weatherClient.contract.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
@Component

public interface IWeatherSettings {
    String getApiKey();
    String getBaseUrl();
    int getApiVersion();
    UriComponentsBuilder getComponentsBuilder();

}
