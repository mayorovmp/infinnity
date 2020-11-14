package ru.infinnity.weather.service;

import ru.infinnity.weather.entity.Weather;

import java.time.ZonedDateTime;
import java.util.List;

public interface WeatherService {
    /**
     * Добавить показание
     * @param cityName город
     * @param v температура в градусах цельсия
     */
    Weather save(String cityName, double v);

    /**
     * Все имеющиеся показания погоды на данную дату
     * @param cityName город
     * @param date дата
     * @return показания погоды
     */
    List<Weather> getWeather(String cityName, ZonedDateTime date);
}
