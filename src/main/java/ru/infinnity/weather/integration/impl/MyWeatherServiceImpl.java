package ru.infinnity.weather.integration.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.infinnity.weather.integration.soap.MyweatherClient;
import ru.infinnity.weather.integration.IntegrationWeatherService;

@Log4j2
@Service
@RequiredArgsConstructor
public class MyWeatherServiceImpl implements IntegrationWeatherService {
    private final MyweatherClient myweatherClient;

    @Override
    public double getTemperature(String name) {
        return myweatherClient.getTemperature(name);
    }
}
