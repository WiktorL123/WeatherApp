package pl.nauka.weatherappclient.weatherClient.contract.forecast;

import lombok.Getter;
import lombok.Setter;
import pl.nauka.weatherappclient.weatherClient.contract.city.CityDto;

import java.util.List;

@Getter
@Setter
public class DailyForecastDto {
    private CityDto city;
    private String date;
    private long epochDate;
    private TemperatureDto temperature;
    private DayDto day;
    private NightDto night;
    private List<String> sources;
}
