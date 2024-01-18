package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pl.nauka.weatherappclient.weatherClient.contract.city.TemperatureDto;

@Getter
@Setter
public class ConditionsDto {
  @JsonIgnore
   private CityInfoDto city;
    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTime;

    @JsonProperty("EpochTime")
    private long epochTime;

    @JsonProperty("WeatherText")
    private String weatherText;

    @JsonProperty("WeatherIcon")
    private int weatherIcon;

    @JsonProperty("HasPrecipitation")
    private boolean hasPrecipitation;

    @JsonProperty("PrecipitationType")
    private String precipitationType;

    @JsonProperty("IsDayTime")
    private boolean isDayTime;

    @JsonProperty("Temperature")
    private TemperatureDto temperature;

    @JsonProperty("MobileLink")
    private String mobileLink;

    @JsonProperty("Link")
    private String link;

}
