package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.nauka.weatherappclient.weatherClient.contract.ImperialDto;
import pl.nauka.weatherappclient.weatherClient.contract.MetricDto;

@Getter
@Setter
public class ElevationDto {
@JsonProperty("Metric")
    private MetricDto metricDto;
@JsonProperty("Imperial")
    private ImperialDto imperial;
}
