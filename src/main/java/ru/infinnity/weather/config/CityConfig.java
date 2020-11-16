package ru.infinnity.weather.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Getter
@Configuration
@ConfigurationProperties(prefix = "dict")
public class CityConfig {
    private final List<String> cities;

    CityConfig() {
        this.cities = new ArrayList<>();
    }
}
