package pl.nauka.weatherappupdater.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nauka.weatherappupdater.updater.IUpdate;
import pl.nauka.weatherappupdater.updater.Updater;

@Controller

public class UpdateController {
    private final IUpdate updater;

    public UpdateController(IUpdate updater) {
        this.updater = updater;
    }

    @GetMapping("update/{cityName}")
    public ResponseEntity update(@RequestParam String cityName){
        updater.updateByCityName(cityName);
        return ResponseEntity.ok("update started");

    }
}
