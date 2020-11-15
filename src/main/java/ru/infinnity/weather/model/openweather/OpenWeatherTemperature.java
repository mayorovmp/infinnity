package ru.infinnity.weather.model.openweather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenWeatherTemperature {
    private Double temp;
    private Double pressure;
    private Double humidity;
}
