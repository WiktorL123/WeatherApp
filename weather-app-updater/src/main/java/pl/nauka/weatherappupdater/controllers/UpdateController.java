package pl.nauka.weatherappupdater.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.nauka.weatherappupdater.updater.IUpdate;
import pl.nauka.weatherappupdater.updater.Updater;

@Controller
@Component
public class UpdateController {
    @Autowired
    private final IUpdate updater;

    public UpdateController(IUpdate updater) {
        this.updater = updater;
    }

    @GetMapping("update/{cityName}")
    public ResponseEntity update( @PathVariable String cityName){
        updater.updateByCityName(cityName);
        return ResponseEntity.ok("update started");

    }
}
