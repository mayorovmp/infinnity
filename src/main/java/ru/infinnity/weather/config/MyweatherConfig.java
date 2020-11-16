package ru.infinnity.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ru.infinnity.weather.integration.soap.MyweatherClient;

@Configuration
public class MyweatherConfig {
    @Value("${myweather.url}")
    private String URL;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ru.infinnity.myweather.wsdl");
        return marshaller;
    }

    @Bean
    public MyweatherClient myweatherClient(Jaxb2Marshaller marshaller) {
        MyweatherClient client = new MyweatherClient();
        client.setDefaultUri(URL);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
