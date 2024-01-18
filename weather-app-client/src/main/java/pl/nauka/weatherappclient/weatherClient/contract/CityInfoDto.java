package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityInfoDto {

    @JsonProperty("Version")
    private int version;

    @JsonProperty("Key")
    private String key;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Rank")
    private int rank;

    @JsonProperty("LocalizedName")
    private String localizedName;

    @JsonProperty("EnglishName")
    private String englishName;

    @JsonProperty("PrimaryPostalCode")
    private String primaryPostalCode;

    @JsonProperty("Region")
    private RegionDto region;

    @JsonProperty("Country")
    private CountryDto country;

    @JsonProperty("AdministrativeArea")
    private AdministrativeAreaDto administrativeArea;

    @JsonProperty("TimeZone")
    private TimeZoneDto timeZone;

    @JsonProperty("GeoPosition")
    private GeoPositionDto geoPosition;

    @JsonProperty("IsAlias")
    private boolean isAlias;

    @JsonProperty("ParentCity")
    private ParentCityDto parentCity;

    @JsonProperty("SupplementalAdminAreas")
    private List<SupplementalAdminAreaDto> supplementalAdminAreas;

    @JsonProperty("DataSets")
    private List<String> dataSets;


}
