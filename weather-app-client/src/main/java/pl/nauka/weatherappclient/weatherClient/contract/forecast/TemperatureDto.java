package pl.nauka.weatherappclient.weatherClient.contract.forecast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureDto {
    private TemperatureValueDto minimum;
    private TemperatureValueDto maximum;
}
