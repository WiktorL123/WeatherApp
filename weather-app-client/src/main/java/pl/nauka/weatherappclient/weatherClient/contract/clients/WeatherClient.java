package pl.nauka.weatherappclient.weatherClient.contract.clients;


import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappclient.weatherClient.contract.ConditionsDto;
import pl.nauka.weatherappclient.weatherClient.contract.ForecastDto;

import java.util.List;

@Component
@Setter

public class WeatherClient implements IWeatherClient {


    private final RestTemplate restTemplate;

    private final IWeatherSettings _settings;
    String baseurl;
    String apiKey;
  //  String baseUrl;
    public WeatherClient( IWeatherSettings settings) {
        this.baseurl=settings.getBaseUrl();
        this.apiKey= settings.getApiKey();
        _settings = settings;
        this.restTemplate = new RestTemplate();
      //  this.baseUrl=settings.getBaseUrl();
    }


    public String getSomeString(){return "some string";}

    @Override
    public List<CityInfoDto> getCityInfo(String cityName) {
        String url=_settings.getComponentsBuilder()
                .pathSegment("locations")
                .pathSegment("v1")
                .pathSegment("cities")
                .pathSegment("search")
                .queryParam("apikey", apiKey)
                .queryParam("q", cityName)
                .build().toUriString();
        System.out.println(url);
        ResponseEntity<List<CityInfoDto>> response=restTemplate.
        exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        return response.getBody();



      //  return restTemplate.getForObject(url, CityDto.class);


    }

    @Override
    public List<ConditionsDto> getCurrentWeather(String cityKey, String cityName) {
        String url=_settings.getComponentsBuilder()
                .pathSegment("currentconditions")
                .pathSegment("v1")
                .pathSegment(cityKey)
                .queryParam("apikey", _settings.getApiKey())
                .build().toUriString();
        System.out.println(url);
      ResponseEntity<List<ConditionsDto>> response=restTemplate.
              exchange(url, HttpMethod.GET, null,
                      new ParameterizedTypeReference<>() {
                      });
         var weatherResponse= response.getBody();
        var city=getCityInfo("gdansk").get(0);
        weatherResponse.get(0).setCity(city);
        System.out.println("getCurrentWeather method has succesfuly set city  as:"+city.getEnglishName());
         return weatherResponse;
//        assert response != null;
//        var city=getCityInfo(response.getCity().getEnglishName());
//        response.setCity(city);
//        return response;
    }

    @Override
    public ForecastDto getWeatherForecast(String cityKey, String cityName) {

        String url=_settings.getComponentsBuilder()
                .pathSegment("forecasts")
                .pathSegment("v1")
                .pathSegment("daily")
                .pathSegment("1day")
                .pathSegment(cityKey).
                queryParam("apikey", _settings.getApiKey())
                .build().toUriString();
        var forecastResponse= restTemplate.getForObject(url, ForecastDto.class);
        var city=getCityInfo(cityName).get(0);
        if (city!=null)
            System.out.println("city is not null");
        forecastResponse.getDailyForecasts().get(0).setCity(city);
        System.out.println("getWeatherForecast method has succesfuly set city  as: "+city.getEnglishName());
        return forecastResponse;
    }
}
