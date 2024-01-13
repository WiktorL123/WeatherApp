package pl.nauka.weatherappclient.weatherClient.contract.city;

import lombok.Getter;
import lombok.Setter;
import pl.nauka.weatherappclient.weatherClient.contract.ImperialDto;
import pl.nauka.weatherappclient.weatherClient.contract.MetricDto;

@Getter
@Setter
public class ElevationDto {

    private MetricDto metricDto;
    private ImperialDto imperial;
}
