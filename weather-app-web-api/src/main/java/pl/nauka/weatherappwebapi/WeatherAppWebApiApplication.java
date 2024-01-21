package pl.nauka.weatherappwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={ "pl.nauka.weatherappdata", "pl.nauka.weatherappwebapi"})
public class WeatherAppWebApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherAppWebApiApplication.class, args);
        System.out.println("ok");
    }

}
