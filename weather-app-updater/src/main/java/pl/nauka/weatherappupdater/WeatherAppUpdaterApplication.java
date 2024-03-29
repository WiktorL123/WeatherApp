package pl.nauka.weatherappupdater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={ "pl.nauka.weatherappupdater", "pl.nauka.weatherappclient"})
public class WeatherAppUpdaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppUpdaterApplication.class, args);
    }

}
