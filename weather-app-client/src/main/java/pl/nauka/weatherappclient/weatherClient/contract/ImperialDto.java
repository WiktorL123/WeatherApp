package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImperialDto {
    @JsonProperty("Value")
    private double value;
    @JsonProperty("Unit")
    private String unit;
@JsonProperty("UnitType")
    private int UnitType;
}
