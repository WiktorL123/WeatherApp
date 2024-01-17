package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministrativeAreaDto {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("Level")
    private int level;
    @JsonProperty("LocalizedType")
    private String localizedType;
    @JsonProperty("EnglishType")
    private String englishType;
    @JsonProperty("CountryID")
    private String countryId;
}
