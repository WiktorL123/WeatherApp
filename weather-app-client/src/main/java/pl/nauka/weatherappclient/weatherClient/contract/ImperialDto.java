package pl.nauka.weatherappclient.weatherClient.contract;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImperialDto {
    private double value;
    private String unit;
    private int UnitType;
}
