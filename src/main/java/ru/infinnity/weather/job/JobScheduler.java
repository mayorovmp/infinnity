package ru.infinnity.weather.job;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Description;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Log4j2
@Component
@EnableScheduling
public class JobScheduler {
    @Value("${cities}")
    private List<String> cities;

    @Description("Синхронизация с сервисами погоды")
    @Scheduled(cron = "${spring.jobs.weather.cron}")
    public void weatherSync() {
        for(String city : cities) {
            log.debug(city);
        }
    }
}
