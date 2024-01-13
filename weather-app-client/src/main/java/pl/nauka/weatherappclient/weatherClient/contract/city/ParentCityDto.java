package pl.nauka.weatherappclient.weatherClient.contract.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentCityDto {

    private String key;
    private String localizedName;
    private String englishName;
}
