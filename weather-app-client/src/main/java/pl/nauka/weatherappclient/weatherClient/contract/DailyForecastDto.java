package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DailyForecastDto {
    @JsonProperty("City")
    private CityDto city;

    @JsonProperty("Date")
    private String date;

    @JsonProperty("EpochDate")
    private long epochDate;

    @JsonProperty("Temperature")
    private TemperatureForecastDto temperature;

    @JsonProperty("Day")
    private DayDto day;

    @JsonProperty("Night")
    private NightDto night;
    @JsonProperty("Sources")
    private List<String> sources;

    @JsonProperty("MobileLink")
    private String mobileLink;

    @JsonProperty("Link")
    private String link;
}
