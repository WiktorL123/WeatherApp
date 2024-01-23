package pl.nauka.weatherappwebapi.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CityDto {
    private long id;
    private String cityKey;

    private String cityName;

    private String country;

    private String timeZone;

}
