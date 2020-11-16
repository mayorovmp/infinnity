package ru.infinnity.weather.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.infinnity.weather.exception.CityNotFoundException;
import ru.infinnity.weather.http.ApiError;

import java.util.Arrays;


/**
 * Общий обработчик ошибок при работе REST контроллеров
 */
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<Object> exceptionHandler(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(ex);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> cityNotFoundExceptionHandler(CityNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError(ex);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
