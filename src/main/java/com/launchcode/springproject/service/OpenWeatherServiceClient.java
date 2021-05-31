package com.launchcode.springproject.service;

import com.launchcode.springproject.WeatherProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

/**
 * Open weather service client.
 */
@Service
public class OpenWeatherServiceClient {

    private static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";
    private static final Logger logger = LoggerFactory.getLogger(OpenWeatherServiceClient.class);
    private final RestTemplate restTemplate;
    private final String apiKey;

    /**
     * Constructor.
     *
     * @param restTemplateBuilder the REST builder
     * @param properties          the weather app properties
     */
    public OpenWeatherServiceClient(RestTemplateBuilder restTemplateBuilder,
                                    WeatherProperties properties) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = properties.getApi().getKey();
    }

    /**
     * Gets the weather from open weather API.
     *
     * @param country the country
     * @param city    the city
     * @return {@link OpenWeather} instance
     */
    public OpenWeather getWeather(String country, String city) {
        logger.info("Requesting current weather for {}/{}", country, city);
        URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
        return invoke(url, OpenWeather.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate
                .exchange(request, responseType);
        return exchange.getBody();
    }

}

// http://localhost:8080/
//http://localhost:8080/weather?selectedLocation=Los%20Angeles%2C+California
