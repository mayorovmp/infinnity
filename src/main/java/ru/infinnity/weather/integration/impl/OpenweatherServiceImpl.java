package ru.infinnity.weather.integration.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.infinnity.weather.exception.WeatherNotFoundException;
import ru.infinnity.weather.model.openweather.OpenWeatherResponse;
import ru.infinnity.weather.integration.OpenweatherService;

import static ru.infinnity.weather.utils.TemperatureUtil.kelvinToCelsius;


@Service
@RequiredArgsConstructor
public class OpenweatherServiceImpl implements OpenweatherService {
    @Value("${openweather.key}")
    private String APP_KEY;
    @Value("${openweather.url}")
    private String URL;

    private final RestTemplate restTemplate;

    @Override
    public double getTemperature(String cityName) {
        ResponseEntity<OpenWeatherResponse> response
                = restTemplate.getForEntity(URL, OpenWeatherResponse.class, cityName, APP_KEY);
        OpenWeatherResponse r = response.getBody();
        if (r != null && r.getList().size() != 0 && r.getList().get(0).getMain() != null) {
            return kelvinToCelsius(r.getList().get(0).getMain().getTemp());
        } else throw new WeatherNotFoundException("Не найдена погода для города " + cityName);
    }
}
