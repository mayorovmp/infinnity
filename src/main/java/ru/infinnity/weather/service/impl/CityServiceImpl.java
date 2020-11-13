package ru.infinnity.weather.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.infinnity.weather.entity.City;
import ru.infinnity.weather.repository.CityRepository;
import ru.infinnity.weather.service.CityService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<City> findByName(String name){
        return cityRepository.findByName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public City save(City city) {
        return cityRepository.save(city);
    }
}
