package pl.nauka.weatherappclient.weatherClient.contract.forecast;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ForecastDto {
    private HeadlineDto headline;
    private List<DailyForecastDto>dailyForecasts;
}
