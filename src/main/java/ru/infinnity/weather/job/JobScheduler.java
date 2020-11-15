package ru.infinnity.weather.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;
import ru.infinnity.weather.config.CityConfig;
import ru.infinnity.weather.entity.Weather;
import ru.infinnity.weather.integration.OpenweatherService;
import ru.infinnity.weather.model.openweather.OpenWeatherResponse;
import ru.infinnity.weather.service.CityService;
import ru.infinnity.weather.service.WeatherService;

import java.util.List;


@Log4j2
@Component
@EnableScheduling
@RequiredArgsConstructor
public class JobScheduler {

    private final CityConfig cityConfig;
    private final OpenweatherService openweatherService;
    private final WeatherService weatherService;

    @Description("Синхронизация с сервисами погоды")
    @Scheduled(cron = "${spring.jobs.weather.cron}")
    public void weatherSync() {
        for (String name : cityConfig.getCities()) {
            double temp1 = openweatherService.getTemperature(name);
            Weather ww = weatherService.save(name, temp1);
            List<Weather> weathers = weatherService.getWeather(name, ww.getTimestamp());
            log.debug(weathers);
        }
    }
}
