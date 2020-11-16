package ru.infinnity.weather.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.infinnity.weather.utils.TemperatureUtil.celsiusToFahrenheit;
import static ru.infinnity.weather.utils.TemperatureUtil.kelvinToCelsius;

@DisplayName("Тестирование утильных методов преобразования температур")
public class TemperatureUtilTests {

    @Test
    void celsiusToFahrenheitTest() {
        double fahrenheit = celsiusToFahrenheit(10);
        assertEquals(fahrenheit, 50.01, 1e-2);
    }

    @Test
    void kelvinToCelsiusTest() {
        double celsius = kelvinToCelsius(274.161);
        assertEquals(celsius, 1.01, 1e-2);
    }
}
