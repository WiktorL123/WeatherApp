package pl.nauka.weatherappupdater.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.nauka.weatherappclient.weatherClient.contract.clients.IWeatherSettings;
import pl.nauka.weatherappupdater.updater.IUpdate;

@RestController
@RequestMapping("/data")

public class UpdateController {

    private final IUpdate updater;

    private final IWeatherSettings settings;

    public UpdateController(IUpdate updater, IWeatherSettings settings) {
        this.updater = updater;
        this.settings = settings;


    }



    @GetMapping("/add/{cityName}")
    public ResponseEntity<String> addDataToDataBase(@PathVariable String cityName){
        if (
        updater.saveDataByCityName(cityName)){
            return ResponseEntity.ok("data succesfully added to data base");
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("city already exists");
        }


    }

    @GetMapping("/update/{cityName}")
    public ResponseEntity<String>updateDataByCityName(@PathVariable String cityName){
        updater.updateByCityName(cityName);
        return ResponseEntity.status(HttpStatus.OK).body("data succesfully updated");

    }
    @DeleteMapping (value = "/delete/{id}")
    public ResponseEntity<String>deleteDataByCityId(@PathVariable Long id){
        try {
            if (updater.deleteDataByCityId(id))
                return ResponseEntity.ok("successfully deleted");
            else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Something went wrong");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getStackTrace());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong"+e.getMessage());
        }
    }
}
