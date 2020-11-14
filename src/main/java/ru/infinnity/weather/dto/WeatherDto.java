package ru.infinnity.weather.dto;

import lombok.*;
import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {
    private Long id;

    private ZonedDateTime timestamp;

    private CityDto city;

    private Double temperatureInCelsius;
    private Double temperatureInFahrenheit;
}
