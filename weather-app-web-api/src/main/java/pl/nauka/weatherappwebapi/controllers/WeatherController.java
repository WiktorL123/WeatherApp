package pl.nauka.weatherappwebapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nauka.weatherappwebapi.services.WeatherService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class WeatherController {
    private final WeatherService service;


    @GetMapping(value = "/cities")
    public String getCities(Model model){
        System.out.println("calling city method");

        model.addAttribute("cities",  service.getCities());
        return "/templates/displayCities";
    }
    @GetMapping(value = "/conditions")
    public String getConditions(Model model){
        model.addAttribute("cities",  service.getConditions());
        return "displayCurrentConditions";
    }


}
