package ru.infinnity.weather.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.infinnity.weather.entity.City;
import ru.infinnity.weather.entity.Weather;
import ru.infinnity.weather.repository.WeatherRepository;
import ru.infinnity.weather.service.CityService;
import ru.infinnity.weather.service.WeatherService;

import javax.persistence.EntityNotFoundException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;
    private final CityService cityService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Weather save(String cityName, double v) {
        City city = cityService.findByName(cityName)
                .orElseGet(() -> cityService.save(
                        City.builder()
                                .name(cityName)
                                .build()));
        Weather weather = Weather.builder()
                .city(city)
                .timestamp(ZonedDateTime.now())
                .value(v).build();
        return weatherRepository.save(weather);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Weather> getWeather(String cityName, ZonedDateTime date) {
        City city = cityService.findByName(cityName).orElseThrow(() -> new EntityNotFoundException("Город не найден"));
        ZonedDateTime dateStart = date.truncatedTo(ChronoUnit.DAYS);
        ZonedDateTime dateEnd = dateStart.plusDays(1);
        return weatherRepository.getWeather(city, dateStart, dateEnd);
    }
}
