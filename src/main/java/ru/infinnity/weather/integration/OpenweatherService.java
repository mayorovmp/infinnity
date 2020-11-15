package ru.infinnity.weather.integration;

public interface OpenweatherService {

    /**
     * Температура сейчас
     * @param cityName город
     * @return показание погоды в цельсиях
     */
    double getTemperature(String cityName);
}
