package pl.nauka.weatherappupdater;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherClient;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherSettings;


import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;

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
