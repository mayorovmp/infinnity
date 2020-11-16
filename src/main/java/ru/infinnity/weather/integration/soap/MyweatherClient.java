package ru.infinnity.weather.integration.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import ru.infinnity.myweather.wsdl.GetWeatherRequest;
import ru.infinnity.myweather.wsdl.GetWeatherResponse;

public class MyweatherClient extends WebServiceGatewaySupport {

    public double getTemperature(String name) {
        GetWeatherRequest request = new GetWeatherRequest();
        request.setName(name);
        GetWeatherResponse response = (GetWeatherResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response.getWeather().getTemperature();
    }
}
