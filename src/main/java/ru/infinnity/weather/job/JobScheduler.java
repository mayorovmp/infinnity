package ru.infinnity.weather.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@EnableScheduling
public class JobScheduler {
    @Description("Синхронизация справочников")
    @Scheduled(cron = "${spring.jobs.weather.cron}")
    public void weatherSync() {
        System.out.println("11");
        log.debug("sync");
    }
}
