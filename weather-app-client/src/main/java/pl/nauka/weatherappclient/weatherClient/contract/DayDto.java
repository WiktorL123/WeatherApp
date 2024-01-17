package pl.nauka.weatherappclient.weatherClient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DayDto {
    @JsonProperty("Icon")
    private int icon;

    @JsonProperty("IconPhrase")
    private String iconPhrase;

    @JsonProperty("HasPrecipitation")
    private boolean hasPrecipitation;
}
