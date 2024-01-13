package pl.nauka.weatherappclient.weatherClient.contract.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionDto {

    private String id;
    private String localizedName;
    private String englishName;
}
