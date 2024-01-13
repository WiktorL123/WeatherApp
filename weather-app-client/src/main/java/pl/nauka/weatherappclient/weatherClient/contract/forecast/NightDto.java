package pl.nauka.weatherappclient.weatherClient.contract.forecast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NightDto {
    private int icon;
    private String iconPhrase;
    private boolean hasPrecipitation;
}
