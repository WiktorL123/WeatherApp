package pl.nauka.weatherappclient.weatherClient.contract.forecast;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeadlineDto {
    private String effectiveDate;
    private long effectiveEpochDate;
    private int severity;
    private String text;
    private String category;
    private String endDate;
    private long endEpochDate;

}
