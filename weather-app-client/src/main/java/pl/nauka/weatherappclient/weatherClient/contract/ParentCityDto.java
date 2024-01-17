package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParentCityDto {
@JsonProperty("Key")
    private String key;
@JsonProperty("LocalizedName")
    private String localizedName;
@JsonProperty("EnglishName")
    private String englishName;
}
