package pl.nauka.weatherappclient.weatherClient.contract.clients;


import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;
import pl.nauka.weatherappclient.weatherClient.contract.conditions.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.forecast.DailyForecastDto;

@Component
@Setter

public class WeatherClient implements IWeatherClient {


    private final RestTemplate restTemplate;

    private final IWeatherSettings settings;
    String baseurl;
    String apiKey;
    String baseUrl;
    public WeatherClient( IWeatherSettings settings) {
        this.baseurl=settings.getBaseUrl();
        this.apiKey= settings.getApiKey();
        this.settings = settings;
        this.restTemplate = new RestTemplate();
        this.baseUrl=settings.getBaseUrl();
    }


    public String getSomeString(){return "some string";}

    @Override
    public CityDto getCityInfo(String cityName) {
        String url=settings.getComponentsBuilder()
                .pathSegment("locations")
                .pathSegment("v1")
                .queryParam("apikey", apiKey)
                .queryParam("q", cityName)
                .build().toUriString();

        return restTemplate.getForObject(url, CityDto.class);
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
        assert response != null;
        var city=getCityInfo(response.getCity().getEnglishName());
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
        assert response != null;
        var city=getCityInfo(response.getCity().getEnglishName());
        response.setCity(city);

        return response;
    }
}
