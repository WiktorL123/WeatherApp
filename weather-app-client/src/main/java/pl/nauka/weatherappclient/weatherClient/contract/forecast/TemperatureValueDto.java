package pl.nauka.weatherappclient.weatherClient.contract.forecast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureValueDto {
    private double value;
    private String unit;
    private int unitType;
}
