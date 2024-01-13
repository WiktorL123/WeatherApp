package pl.nauka.weatherappclient.weatherClient.contract.conditions;

import lombok.Getter;
import lombok.Setter;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;

@Getter
@Setter
public class ConditionsDto {

    private CityDto city;
    private String localObservationDateTime;
    private long epochTime;
    private String weatherText;
    private int weatherIcon;
    private boolean hasPrecipitation;
    private String precipitationType;
    private boolean isDayTime;
    private TemperatureDto temperature;
}
