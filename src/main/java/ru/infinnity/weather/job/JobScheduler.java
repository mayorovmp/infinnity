package ru.infinnity.weather.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Description;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.infinnity.weather.entity.City;
import ru.infinnity.weather.entity.Weather;
import ru.infinnity.weather.service.CityService;
import ru.infinnity.weather.service.WeatherService;

import java.util.List;
import java.util.Optional;


@Log4j2
@Component
@EnableScheduling
@RequiredArgsConstructor
public class JobScheduler {
    @Value("${cities}")
    private List<String> cities;

    private final CityService cityService;
    private final WeatherService weatherService;

    @Description("Синхронизация с сервисами погоды")
    @Scheduled(cron = "${spring.jobs.weather.cron}")
    public void weatherSync() {
        for(String name : cities) {
            Weather w = weatherService.save(name, 12);
            List<Weather> weathers = weatherService.getWeather(name, w.getTimestamp());
            log.debug(weathers.get(0));
        }
    }
}
