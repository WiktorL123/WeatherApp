package pl.nauka.weatherappclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "pl.nauka")
public class WeatherAppClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppClientApplication.class, args);

    }

}
