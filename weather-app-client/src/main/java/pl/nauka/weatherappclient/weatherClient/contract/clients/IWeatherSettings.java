package pl.nauka.weatherappclient.weatherClient.contract.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

public interface IWeatherSettings {
    String getApiKey();
    String getBaseUrl();
    int getApiVersion();

    default UriComponentsBuilder getComponentsBuilder() {
        return UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(getBaseUrl())
//                .pathSegment("v"+getApiVersion())
             ;
    }

}
