package ru.infinnity.weather.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.infinnity.weather.Mapper.Mapper;
import ru.infinnity.weather.dto.WeatherDto;
import ru.infinnity.weather.entity.Weather;
import ru.infinnity.weather.service.WeatherService;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;
    private final Mapper mapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<WeatherDto>> get(
            @RequestParam("city") final String cityName,
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime date) {
        Collection<Weather> results = null;
        if (date == null) {
            results = Collections.singleton(weatherService.getWeather(cityName));
        } else {
            results = weatherService.getWeather(cityName, date);

        }
        return ResponseEntity.ok(mapper.mapList(results, WeatherDto.class));
    }
}
