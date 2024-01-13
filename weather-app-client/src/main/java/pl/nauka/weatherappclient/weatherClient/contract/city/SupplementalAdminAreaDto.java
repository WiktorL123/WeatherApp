package pl.nauka.weatherappclient.weatherClient.contract.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplementalAdminAreaDto {
    private int level;
    private String localizedName;
    private String englishName;
}
