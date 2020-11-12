package ru.infinnity.weather.job;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Description;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Log4j2
@Component
@EnableScheduling
public class JobScheduler {
    @Description("Синхронизация справочников")
    @Scheduled(cron = "${spring.jobs.weather.cron}")
    public void weatherSync() {
        log.debug("sync");
    }
}
