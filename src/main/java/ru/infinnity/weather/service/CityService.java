package ru.infinnity.weather.service;

import ru.infinnity.weather.entity.City;

import java.util.Optional;

public interface CityService {
    Optional<City> findByName(String name);

    City save(City city);
}
