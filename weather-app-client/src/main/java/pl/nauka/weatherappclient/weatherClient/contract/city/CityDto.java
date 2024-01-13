package pl.nauka.weatherappclient.weatherClient.contract.city;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDto {
    private int version;
    private String key;
    private String type;
    private int rank;
    private String localizedName;
    private String englishName;
    private String primaryPostalCode;
    private RegionDto region;
    private CountryDto country;
    private AdministrativeAreaDto administrativeArea;
    private TimeZoneDto timeZone;
    private GeoPositionDto geoPosition;
    private boolean isAlias;
    private ParentCityDto parentCity;
    private List<SupplementalAdminAreaDto> supplementalAdminAreas;
    private List<String> dataSets;


}
