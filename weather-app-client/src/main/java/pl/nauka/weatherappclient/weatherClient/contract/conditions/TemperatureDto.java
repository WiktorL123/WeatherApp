package pl.nauka.weatherappclient.weatherClient.contract.conditions;

import lombok.Getter;
import lombok.Setter;
import pl.nauka.weatherappclient.weatherClient.contract.ImperialDto;
import pl.nauka.weatherappclient.weatherClient.contract.MetricDto;
@Getter
@Setter
public class TemperatureDto {
    private MetricDto metric;
    private ImperialDto imperial;

}
