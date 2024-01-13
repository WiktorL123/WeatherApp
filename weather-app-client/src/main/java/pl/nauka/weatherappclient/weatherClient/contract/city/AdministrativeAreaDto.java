package pl.nauka.weatherappclient.weatherClient.contract.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministrativeAreaDto {

    private String id;
    private String localizedName;
    private String englishName;
    private int level;
    private String localizedType;
    private String englishType;
    private String countryId;
}
