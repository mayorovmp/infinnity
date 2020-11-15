package ru.infinnity.weather.model.openweather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenWeatherResponse {
    private String cod;
    private String message;
    private List<OpenWeatherData> list;
}
