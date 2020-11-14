package ru.infinnity.weather.http;

import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Arrays;

@Getter
public class ApiError {
    private final String message;
    private final ZonedDateTime timestamp;
    private final String error;

    public ApiError(String message, String error) {
        this.message = message;
        this.error = error;
        this.timestamp = ZonedDateTime.now();
    }

    public ApiError(Exception e) {
        this.message = e.getLocalizedMessage();
        this.error = Arrays.toString(e.getStackTrace());
        this.timestamp = ZonedDateTime.now();
    }
}
