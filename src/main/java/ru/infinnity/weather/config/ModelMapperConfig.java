package ru.infinnity.weather.config;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.infinnity.weather.dto.WeatherDto;
import ru.infinnity.weather.entity.Weather;

import static ru.infinnity.weather.utils.TemperatureUtil.celsiusToFahrenheit;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true);
        configureWeather(mapper);
        return mapper;
    }

    private static void configureWeather(ModelMapper modelMapper) {
        modelMapper.createTypeMap(Weather.class, WeatherDto.class).addMappings(new PropertyMap<Weather, WeatherDto>() {
            @Override
            protected void configure() {
                map(source.getValue(), destination.getTemperatureInCelsius());

                using((Converter<Weather, Double>)
                        context -> context.getSource() == null || context.getSource().getValue() == null
                                ? null : celsiusToFahrenheit(context.getSource().getValue()))
                        .map(source, destination.getTemperatureInFahrenheit());
            }
        });
    }

}
