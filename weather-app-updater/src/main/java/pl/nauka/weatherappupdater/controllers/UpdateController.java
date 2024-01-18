package pl.nauka.weatherappupdater.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherSettings;
import pl.nauka.weatherappupdater.updater.IUpdate;

@Controller

public class UpdateController {

    private final IUpdate updater;

    private final IWeatherSettings settings;

    public UpdateController(IUpdate updater, IWeatherSettings settings) {
        this.updater = updater;
        this.settings = settings;


    }

//    @GetMapping("update/{cityName}")
//    public ResponseEntity<String> update( @PathVariable String cityName){
//        try {
//            updater.updateByCityName(cityName);
//            CityDto cityDto=updater.getNameOfCity(cityName);
//            return ResponseEntity.ok("ok"+cityDto.getEnglishName());
//          ConditionsDto dto= updater.getText("1-275174_1_AL");
//            return ResponseEntity.ok(dto.getWeatherText());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating data");
//        }
//
//    }
//    @GetMapping("/cities")
//    public ResponseEntity<List<CityDto>> getCities(@PathVariable String cityName){
//        var cities=updater.getNameOfCity("gdansk");
//        return ResponseEntity.ok(cities);
//}
    @GetMapping("/test/conditions")
    public ResponseEntity<Double> getConditons(){
        var conditions=updater.getConditions();
        return ResponseEntity.ok(conditions.getTemperature().getMetric().getValue());
    }
    @GetMapping("/test/city")
    public ResponseEntity<String> getCity() {
        var cityInfo = updater.getCity();
        return ResponseEntity.ok(
                cityInfo.getLocalizedName());
    }
//        @GetMapping("test/forecast")
//                public ResponseEntity<String>getForecast(){
//            var forecastInfo=updater.getDailyForecast();
//            return ResponseEntity.ok(forecastInfo.getDailyForecasts().get(0).getDate());
//        }


    @GetMapping("/test")
    public ResponseEntity<String> test(){
            updater.updateByCityName("gdansk");
         //  var forecast = updater.getDailyForecast();
         //  var conditions=updater.getConditions();
    //    return ResponseEntity.status(HttpStatus.OK).body("OK"+conditions.getWeatherText()+ " " +forecast.getHeadline().getText());
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }
}
