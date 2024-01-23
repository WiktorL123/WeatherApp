package pl.nauka.weatherappdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.nauka.weatherappdata.repositories.ICatalogData;

@SpringBootApplication(scanBasePackages = "pl.nauka.weatherappdata")
public class WeatherAppDataApplication {
    private final ICatalogData db;

    public WeatherAppDataApplication(ICatalogData db) {
        this.db = db;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppDataApplication.class, args);
    }

}
