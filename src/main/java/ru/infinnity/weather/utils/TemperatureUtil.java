package ru.infinnity.weather.utils;

public class TemperatureUtil {
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }
    public static double kelvinToCelsius(double v) {
        return v - 273.15;
    }
}
