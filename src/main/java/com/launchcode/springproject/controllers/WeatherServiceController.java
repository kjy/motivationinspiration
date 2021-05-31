package com.launchcode.springproject.controllers;

import com.launchcode.springproject.service.OpenWeather;
import com.launchcode.springproject.service.OpenWeatherServiceClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Open weather service API controller.
 */
@RestController
@RequestMapping("/api/weather")
public class WeatherServiceController {

    private final OpenWeatherServiceClient weatherService;

    /**
     * Constructor.
     *
     * @param weatherService the {@link OpenWeatherServiceClient}
     */
    public WeatherServiceController(OpenWeatherServiceClient weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Returns the current weather for the given location.
     *
     * @param country the country
     * @param city    the city
     * @return {@link OpenWeather} instance
     */
    @RequestMapping("/now/{country}/{city}")
    public OpenWeather getWeather(@PathVariable String country,
                                  @PathVariable String city) {
        return this.weatherService.getWeather(country, city);
    }

}
