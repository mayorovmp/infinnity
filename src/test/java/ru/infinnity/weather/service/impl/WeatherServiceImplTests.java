package ru.infinnity.weather.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.infinnity.weather.exception.CityNotFoundException;
import ru.infinnity.weather.repository.WeatherRepository;
import ru.infinnity.weather.service.CityService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Тестирование сервиса работы с погодой")
public class WeatherServiceImplTests {
    private WeatherRepository weatherRepository;
    private CityService cityService;
    private WeatherServiceImpl weatherService;

    @BeforeEach
    void setUp() {
        weatherRepository = mock(WeatherRepository.class);
        cityService = mock(CityService.class);
        weatherService = new WeatherServiceImpl(weatherRepository, cityService);
    }

    @Test
    void cityNotFoundTest() {
        String notExistedCity = anyString();
        when(cityService.findByName(notExistedCity)).thenReturn(Optional.empty());

        Exception exception = assertThrows(CityNotFoundException.class, () -> {
            weatherService.getWeather(notExistedCity);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(notExistedCity));
    }

}
