package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ForecastDto {
    @JsonProperty("Headline")
    private HeadlineDto headline;
    @JsonProperty("DailyForecasts")
    private List<DailyForecastDto>dailyForecasts;


}
