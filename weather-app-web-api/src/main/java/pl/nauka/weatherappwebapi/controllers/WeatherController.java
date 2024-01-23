package pl.nauka.weatherappwebapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.nauka.weatherappwebapi.contract.CityDto;
import pl.nauka.weatherappwebapi.services.WeatherService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class WeatherController {
    private final WeatherService service;


    @GetMapping(value = "/cities")
    public String getCities(Model model){
        System.out.println("calling city method");

        model.addAttribute("cities",  service.getCities());
        return "displayCities";
    }
    @GetMapping(value = "/conditions")
    public String getConditions(Model model){
        model.addAttribute("conditions",  service.getConditions());
        return "displayCurrentWeather";
    }
    @GetMapping(value = "/forecasts")
    public String getForecasts(Model model){
        model.addAttribute("forecasts", service.getForecasts());
        return "displayForecasts";
    }
    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable Long id, Model model){
        CityDto cityDto = service.findCityDtoById(id);
        model.addAttribute("city", cityDto);
        return "deleteConfirm";
       }

    @PostMapping("delete/confirm/{id}")
    public String confirmDelete(@PathVariable Long id){
        if (service.deleteWeatherData(id))
            return "redirect:/displayCities";
        else {
            return "errorPage";
        }

    }


}
