package ru.infinnity.weather.model.openweather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OpenWeatherData {
    private int id;
    private OpenWeatherTemperature main;
}
