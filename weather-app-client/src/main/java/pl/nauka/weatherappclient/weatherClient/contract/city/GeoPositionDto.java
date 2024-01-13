package pl.nauka.weatherappclient.weatherClient.contract.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeoPositionDto {
    private double latitude;
    private double longitude;
    private ElevationDto elevation;

}
