package pl.nauka.weatherappupdater;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;

import static org.mockito.ArgumentMatchers.anyString;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherSettings;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherClient;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherSettings;


import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import org.junit.Test;

public class ClientTest {


        @Mock
        private RestTemplate restTemplate;

        @InjectMocks
        private WeatherSettings settings;
        @Mock
        WeatherClient client;

        @Test
        public void testGetCityInfo() {
            settings= new WeatherSettings();







        }


}
