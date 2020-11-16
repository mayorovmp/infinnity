package ru.infinnity.weather.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.infinnity.weather.entity.City;
import ru.infinnity.weather.entity.Weather;

import java.time.ZonedDateTime;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    @Query("select w " +
            "from Weather w " +
            "where w.timestamp >= :dateStart " +
            "and w.timestamp <= :dateEnd " +
            "and w.city = :city")
    List<Weather> getWeather(City city, ZonedDateTime dateStart, ZonedDateTime dateEnd);

    @Query("select w " +
            "from Weather w " +
            "where " +
            "w.city = :city " +
            "order by w.timestamp desc")
    Page<Weather> getWeather(City city, Pageable pageable);
}
