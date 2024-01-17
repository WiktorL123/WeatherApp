package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeZoneDto {
@JsonProperty("Code")
    private String code;

@JsonProperty("Name")
    private String name;

@JsonProperty("GmtOffset")
    private double gmtOffset;
@JsonProperty("IsDayLightSaving")
    private boolean isDaylightSaving;
@JsonProperty("NextOffsetChange")
    private String nextOffsetChange;
}
