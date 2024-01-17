package pl.nauka.weatherappclient.weatherClient.contract.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.nauka.weatherappclient.weatherClient.contract.ImperialDto;
import pl.nauka.weatherappclient.weatherClient.contract.MetricDto;
@Getter
@Setter
public class TemperatureDto {
    @JsonProperty("Metric")
    private MetricDto metric;
    @JsonProperty("Imperial")
    private ImperialDto imperial;

}
