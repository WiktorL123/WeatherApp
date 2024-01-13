package pl.nauka.weatherappclient.weatherClient.contract.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeZoneDto {

    private String code;
    private String name;
    private double gmtOffset;
    private boolean isDaylightSaving;
    private String nextOffsetChange;
}
