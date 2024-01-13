package pl.nauka.weatherappclient.weatherClient.contract.clients;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.conditions.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.forecast.DailyForecastDto;

@Component
public class WeatherClient implements IWeatherClient {

    private final RestTemplate restTemplate;
    private final IWeatherSettings settings;


    public WeatherClient( IWeatherSettings settings, RestTemplate restTemplate) {
        this.settings = settings;
        this.restTemplate = restTemplate;
    }

    @Override
    public CityDto getCityInfo(String cityName) {
        String url=settings.getComponentsBuilder()
                .pathSegment("locations")
                .pathSegment("v1")
                .queryParam("apikey", settings.getApiKey())
                .queryParam("q", cityName)
                .build().toUriString()
                ;

        var response= restTemplate.getForObject(url, CityDto.class);
            return response;
    }

    @Override
    public ConditionsDto getCurrentWeather(String cityKey) {
        String url=settings.getComponentsBuilder()
                .pathSegment("currentconditions")
                .pathSegment("v1")
                .pathSegment(cityKey)
                .queryParam("apikey", settings.getApiKey())
                .build().toUriString();
        var response=restTemplate.getForObject(url, ConditionsDto.class);
        var city=getCityInfo("gdansk");
        assert response != null;
        response.setCity(city);
        return response;
    }

    @Override
    public DailyForecastDto getWeatherForecast(String cityKey) {

        String url=settings.getComponentsBuilder()
                .pathSegment("forecasts")
                .pathSegment("v1")
                .pathSegment(cityKey).
                queryParam("apikey", settings.getApiKey())
                .build().toUriString();

        var response= restTemplate.getForObject(url, DailyForecastDto.class);
        var city=getCityInfo("gdansk");
        assert response != null;
        response.setCity(city);

        return response;
    }
}
