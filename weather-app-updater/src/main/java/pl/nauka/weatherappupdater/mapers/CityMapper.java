package pl.nauka.weatherappupdater.mapers;

import org.springframework.stereotype.Component;
import pl.nauka.weatherappclient.weatherClient.contract.CityInfoDto;
import pl.nauka.weatherappdata.model.City;

@Component
public class CityMapper implements IMapEntity<City, CityInfoDto>{

    private pl.nauka.weatherappdata.model.City City;

    @Override
    public City map(CityInfoDto dto) {
        return map(dto, new City());
    }

    @Override
    public City map(CityInfoDto dto, City city) {
        city.setCityName(dto.getEnglishName());
        city.setCountry(dto.getCountry().getEnglishName());
        city.setCityKey(dto.getKey());
        city.setTimeZone(dto.getTimeZone().getName());
        return city;
    }
}
