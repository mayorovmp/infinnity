package ru.infinnity.weather.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Description;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.infinnity.weather.config.CityConfig;
import ru.infinnity.weather.entity.Weather;
import ru.infinnity.weather.integration.IntegrationWeatherService;
import ru.infinnity.weather.service.WeatherService;

import java.util.List;


@Log4j2
@Component
@EnableScheduling
@RequiredArgsConstructor
public class JobScheduler {

    private final CityConfig cityConfig;
    private final List<IntegrationWeatherService> integrationWeatherServices;
    private final WeatherService weatherService;

    @Description("Синхронизация с сервисами погоды")
    @Scheduled(cron = "${spring.jobs.weather.cron}")
    public void weatherSync() {
        for (String name : cityConfig.getCities()) {
            double sumOfTemperature = 0;
            for (IntegrationWeatherService integrationService: integrationWeatherServices) {
                sumOfTemperature += integrationService.getTemperature(name);
            }
            Weather weather = weatherService.save(name, sumOfTemperature / integrationWeatherServices.size());
            List<Weather> weathers = weatherService.getWeather(name, weather.getTimestamp());
            log.debug(weathers);
        }
    }
}
