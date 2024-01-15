package pl.nauka.weatherappupdater.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherClient;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherSettings;
import pl.nauka.weatherappclient.weatherClient.contract.clients.WeatherClient;
import pl.nauka.weatherappupdater.updater.IUpdate;
import pl.nauka.weatherappupdater.updater.Updater;

@Controller

public class UpdateController {

    private final IUpdate updater;

    private final IWeatherSettings settings;

    public UpdateController(IUpdate updater, IWeatherSettings settings) {
        this.updater = updater;
        this.settings = settings;


    }

    @PostMapping("update/{cityName}")
    public ResponseEntity update( @PathVariable String cityName){
        try {
            updater.updateByCityName(cityName);
            return ResponseEntity.ok("update started");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating data");
        }

    }
    @GetMapping("/test")
    public ResponseEntity<String> test(){

        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
