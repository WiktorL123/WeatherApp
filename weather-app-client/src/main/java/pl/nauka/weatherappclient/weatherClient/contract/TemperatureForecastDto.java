package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureForecastDto {
    @JsonProperty("Minimum")
    private TemperatureForecastDto minimum;

    @JsonProperty("Maximum")
    private TemperatureForecastDto maximum;
}
