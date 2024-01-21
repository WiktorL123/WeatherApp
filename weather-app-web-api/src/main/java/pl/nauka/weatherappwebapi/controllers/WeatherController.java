package pl.nauka.weatherappwebapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nauka.weatherappwebapi.contract.CityDto;
import pl.nauka.weatherappwebapi.services.WeatherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WeatherController {
    private final WeatherService service;


    @GetMapping("/cities")
    public List<CityDto> cities(){
        return service.getCities();
    }


}
