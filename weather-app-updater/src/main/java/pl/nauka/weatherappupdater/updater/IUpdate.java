package pl.nauka.weatherappupdater.updater;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public interface IUpdate {
    void updateByCityName(String cityName);
}
